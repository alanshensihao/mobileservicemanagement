import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManagement implements PropertyChangeListener
{
  Map<String, User> users = new HashMap<>();
  private MessageContainer messageContainer;

  ServerMessageHandler serverMessageHandler;

  public UserManagement()
  {

  }

  public UserManagement(ServerMessageHandler msgHandler)
  {
    this.serverMessageHandler = msgHandler;
  }

  public void propertyChange(PropertyChangeEvent evt)
  {
    System.out.println("user management activity");
    this.messageContainer = (MessageContainer)evt.getNewValue();
    this.performRequestedTask();
  }

  public void performRequestedTask()
  {
    User user;
    List<User> userList = new ArrayList<>();
    StringBuilder returnMsg = new StringBuilder();
    boolean isSuccessful = false;
    boolean isHandled = true;
    switch(messageContainer.menuOption)
    {
      case ADD_USER:
        user = this.createUser(messageContainer.messageContents);
        isSuccessful = this.addUser(user);
        if (isSuccessful)
        {
          returnMsg.append("Successfully added user!\n");
          break;
        }
        returnMsg.append("Failed to add user: User already exists or invalid data given.\n");
        break;

      case ADD_USERS:
        userList = this.createUserList(messageContainer.messageContents);
        isSuccessful = this.addUsers(userList);
        if (isSuccessful)
        {
          returnMsg.append("Successfully added list of users!\n");
          break;
        }
        returnMsg.append("Failed to add list of users. One of the users likely already exists.\n");
        break;

      case UPDATE_USER:
        user = this.createUser(messageContainer.messageContents);
        isSuccessful = this.updateUser(user);
        if (isSuccessful)
        {
          returnMsg.append("Successfully updated user!\n");
          break;
        }
        returnMsg.append("Failed to update the user. Does not exist\n");
        break;

      case DELETE_USER:
        String userName = messageContainer.messageContents.get(0);
        isSuccessful = this.deleteUser(userName);
        if (isSuccessful)
        {
          returnMsg.append("Successfully delete user!\n");
          break;
        }
        returnMsg.append("Failed delete user!\n");
        break;

      case DELETE_USERS:
        List<String> userNameList = this.createUserNameList(messageContainer.messageContents);
        isSuccessful = this.deleteUsers(userNameList);
        if (isSuccessful)
        {
          returnMsg.append("Successfully delete user!\n");
          break;
        }
        returnMsg.append("Failed delete user!\n");
        break;

      case LIST_USER_DETAILS:
        user = this.getUser(messageContainer.messageContents.get(0));
        returnMsg = new StringBuilder();
        if (user != null) {
          isSuccessful = true;
          returnMsg.append(user.fullName + " " + user.address + " " + user.email);
          break;
        }
        returnMsg.append("user does not exist!\n");
        break;

      case LIST_ALL_USERS:
        returnMsg = new StringBuilder();
        int i = 1;
        for (String eachUserName : this.users.keySet()) {
          returnMsg.append("user " + i + ": " + eachUserName + " ");
          isSuccessful = true;
          i++;
        }
        if (!isSuccessful) {
          returnMsg.append("no users yet");
        }
        break;

      default:
        isHandled = false;
        System.out.println("Nothing to be done by User Manager.\n");
        break;
    }
    // TODO: I'd suggest designing the code so this is the only message call.
    // ie. Return the output of a task to performRequestedTask and then send it here.
    if (isHandled) {
      serverMessageHandler.buildAndSendResponseMessage(messageContainer.menuOption, isSuccessful, returnMsg.toString());
    }
  }

  public User createUser(List<String> messageContents) {
    String fullName = messageContainer.messageContents.get(0) 
              + " " + messageContainer.messageContents.get(1);
    // String phoneNumber = messageContainer.messageContents.get(2);
    String address = messageContainer.messageContents.get(3);
    String email = messageContainer.messageContents.get(4);

    return new User(fullName, address, email);
  }

  public List<User> createUserList(List<String> messageContents) {
    List<User> userList = new ArrayList<>();
    for (int i = 0; i < messageContainer.messageContents.size(); i+=5) {
      String fullName = messageContainer.messageContents.get(i) + messageContainer.messageContents.get(i + 1);
      // String phoneNumber = messageContainer.messageContents.get(i + 2);
      String address = messageContainer.messageContents.get(i + 3);
      String email = messageContainer.messageContents.get(i + 4);
      userList.add(new User(fullName, address, email));
    }

    return userList;
  }

  public List<String> createUserNameList(List<String> messageContents) {
    //serverMessageHandler.sendMessage("User" + user.getName() + " added to the list of users.\n");
    List<String> userNameList = new ArrayList<>();
    for (String userName: messageContents) {
      userNameList.add(userName);
    }

    return userNameList;
  }

  public boolean addUser(User user)
  {
    if (users.containsKey(user.getName()))
    {
      System.out.println("Cannot add: " + user.getName() + " because they already exist in the system.\n");
      return false;
    }
    users.put(user.fullName, user);
    System.out.println("User: " + user.getName() + " added to the list of users.\n");
    return true;
  }

  public boolean addUsers(List<User> userList)
  {
    for (User user : userList)
    {
      boolean success = addUser(user);
      if (!success)
      {
        System.out.println("Failed to add atleast one user. Returning false.");
        return false;
      }
    }
    return true;
  }

  public User getUser(String fullName)
  {
    return users.get(fullName);
  }

  public boolean updateUser(User user)
  {
    User userUpdate = users.get(user.fullName);
    if (users.containsKey(user.fullName))
    {
      userUpdate.address = user.address;
      userUpdate.email = user.email;
      return true;
    }
    return false;
  }

  public boolean deleteUser(String fullName)
  {
    if (!users.containsKey(fullName))
    {
      return false;
    }
    System.out.println("WARNING: Removing user: " + fullName + " and all associated accounts.\n");
    users.remove(fullName);
    return true;
  }

  public boolean deleteUsers(List<String> userNameList)
  {
    boolean someDeleted = false;
    for (String userName : userNameList)
    {
      deleteUser(userName);
      someDeleted = true;
    }
    return someDeleted;
  }

  public void addAssociatedAccountsNo(User user) 
  {
    User userNumOfAssociatedAccounts = users.get(user.fullName);
    if (user != null)
    {
      userNumOfAssociatedAccounts.numOfAssociatedAccounts += 1;
    }
  }
}
