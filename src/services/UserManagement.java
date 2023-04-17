package services;
import java.util.*;
import models.User;
import services.AccountManagement;

public class UserManagement {
    
    Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        if (this.users.containsKey(user.getName())) {
            System.out.println("Cannot add: " + user.getName() + " because they already exist in the system.\n");
            return;
        }
        users.put(user.fullName, user);
        users.put(user.address, user);
        System.out.println("users: " + users);
    }

    public void addUsers(ArrayList<User> userList) {
        for (var iter : userList) {
            this.addUser(iter);
        }
    }

    public User getUser(String fullName) {
        return users.get(fullName);
    }

    public void updateUser(String fullName, String address, String email) {
        User user = users.get(fullName);
        if (user != null) {
            user.address = address;
            user.email = email;
        }
    }

    public void deleteUser(String fullName) {
        System.out.println("WARNING: Removing user: " + fullName + " and all associated accounts.\n");

        // add functionality for removing associated accounts upon call

        users.remove(fullName);
    }

    public void deleteUsers(ArrayList<User> userList) {
        for (var iter : userList) {
            this.deleteUser(iter);
        }
    }
}