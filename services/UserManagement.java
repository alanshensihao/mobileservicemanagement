package services;
import java.util.*;
import models.User;

public class UserManagement {
    
    Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.fullName, user);
        users.put(user.address, user);
        System.out.println("users: " + users);
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
        users.remove(fullName);
    }
}
