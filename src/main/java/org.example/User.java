package org.example;

import java.util.List;

public class User {
    private String username;
    private String fullName;
    private String password;
    List<Tweet> tweets;
    List<User> followers;
    List<User> following;

    public User() {
    }
}
