import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class UserManagement implements PropertyChangeListener
{
  Map<String, User> users = new HashMap<>();
  private MessageContainer messageContainer;

  ServerMessageHandler serverMessageHandler;

  public UserManagement(ServerMessageHandler msgHandler)
  {
    this.serverMessageHandler = msgHandler;
  }

  public void propertyChange(PropertyChangeEvent evt)
  {
    this.messageContainer = (MessageContainer)evt.getNewValue();
    this.performRequestedTask();
  }

  public void performRequestedTask()
  {
    // case wise handling of message passed down by server
    switch(messageContainer.menuOption)
    {
      case ADD_USER:
        System.out.println("Adding user!");
        serverMessageHandler.sendMessage("Adding User!\n");
        break;

      case ADD_USERS:
        break;

      case UPDATE_USER:
        break;

      case DELETE_USER:
        break;

      case DELETE_USERS:
        break;

      case ADD_ACCOUNT_V1:
        break;

      case ADD_ACCOUNT_V2:
        break;

      case DELETE_ACCOUNT:
        break;

      case UPDATE_ACCOUNT:
        break;

      case ADD_PRE_BUNDLE:
        break;

      case ADD_PAC_BUNDLE_V1:
        break;

      case ADD_PAC_BUNDLE_V2:
        break;

      case ADD_PAC_BUNDLE_V3:
        break;

      case LIST_USER_DETAILS:
        break;

      case LIST_ALL_USERS:
        break;

      case LIST_ACCOUNT:
        break;

      case LIST_ACCOUNTS:
        break;

      case LIST_MONTHLY_FEES:
        break;

      case LIST_MONTHLY_FEES_ALL:
        break;

      case LIST_BUNDLE_DETAILS:
        break;

      case LIST_ALL_PRE_BUNDLES:
        break;

      case LIST_ALL_PAC_BUNDLES:
        break;

      default:
        System.out.println("Nothing to be done by User Manager.\n");
        break;
    }
  }

  public void addUser(User user)
  {
    if (this.users.containsKey(user.getName()))
    {
      System.out.println("Cannot add: " + user.getName() + " because they already exist in the system.\n");
      return;
    }
    users.put(user.fullName, user);
    System.out.println("users: " + users);
  }

  public void addUsers(List<User> userList)
  {
    for (User user : userList)
    {
      if (user.getUserId() == 0)
      {
        user.setUserId(users.size() + 1);
      }
      addUser(user);
    }
  }

  public User getUser(String fullName)
  {
    return users.get(fullName);
  }

  public void updateUser(String fullName, String address, String email)
  {
    User user = users.get(fullName);
    if (user != null)
    {
      user.address = address;
      user.email = email;
    }
  }

  public void deleteUser(String fullName)
  {
    System.out.println("WARNING: Removing user: " + fullName + " and all associated accounts.\n");
    users.remove(fullName);
  }

  public void deleteUsers(List<User> userList)
  {
    for (User user : userList)
    {
      deleteUser(user.fullName);
    }
  }
}
