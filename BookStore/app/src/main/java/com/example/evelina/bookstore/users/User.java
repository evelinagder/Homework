package com.example.evelina.bookstore.users;

/**
 * Created by Evelina on 8/30/2016.
 */
public class User {
    private String username;
    private String name;
    private String password;
    private String email;

    public User(String username, String name, String password, String email){
        this.username=username;
        this.name=name;
        this.password=password;
        this.email=email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
