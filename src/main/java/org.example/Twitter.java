package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class Twitter {
    List<User> users = new ArrayList<>();
    List<Tweet> tweets = new ArrayList<>();

    public void addUser(User user) {
        System.out.println(user);
        if (user != null) {
            users.add(user);
        } else {
            System.out.println("User is null");
        }

    }

    public User login(String userName, String password) {
        User userLog = (User) users.stream()
                .filter(user -> user.getUsername().equals(userName));
        if (userLog.getPassword().equals(password)) {
            return userLog;
        }
        return null;
    }

    public void displayFeed(User user) {
        user.getFollowing().stream().forEach(tweet -> tweet.getTweets().forEach(tw -> System.out.println(tw)));
    }

    public void displayUserTweets(String userName) {
        User user = findUserByUsername(userName);
        System.out.println(user.getTweets());
    }

    public User findUserByUsername(String userName) {
        User user = (User) users.stream()
                .filter(n -> n.getUsername().equals(userName));
        return user;

    }
}
