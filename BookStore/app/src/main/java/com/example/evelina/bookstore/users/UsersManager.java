package com.example.evelina.bookstore.users;

import java.util.HashMap;

/**
 * Created by Evelina on 8/30/2016.
 */
public class UsersManager {
    private static UsersManager ourInstance = new UsersManager();

    public static UsersManager getInstance() {
        return ourInstance;
    }

    private UsersManager() {
    }

    HashMap<String, User> users = new HashMap<>();

    public void registerUser(User user) {
        if (!users.containsKey(user.getUsername())) {
            users.put(user.getUsername(), user);

        }
    }

    public boolean validateLogin(String username, String password) {
        if( users.containsKey(username)){
            User user=users.get(username);
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}



