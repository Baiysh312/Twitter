package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class User {
    private String username;
    private String fullName;
    private String password;
    private List<Tweet> tweets;
    private List<User> followers;
    private List<User> following;

    public User(String username, String fullName, String password) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
    }

    public void follow(User user) {
        if (!following.contains(user)) {
            following.add(user);
            user.addFollowers(this);
        }
    }
    public void unFollow(User user){
        if(following.contains(user)){
            following.remove(user);
            user.followers.remove(this);
        }
    }
    public void addTweet(Tweet tweet){
        if(!tweets.contains(tweet)){
            tweets.add(tweet);
        }
    }
    public void addFollowers(User user){
        if(!followers.contains(user)){
            followers.add(user);
            user.following.add(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
