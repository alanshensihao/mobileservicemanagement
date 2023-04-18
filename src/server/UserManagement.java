import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class UserManagement
{
  Map<String, User> users = new HashMap<>();

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
