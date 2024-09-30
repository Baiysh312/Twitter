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
        if (user != null) {
            users.add(user);
        } else {
            System.out.println("User is null");
        }
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public User login(String userName, String password) {
        User userLog = users.stream()
                .filter(user -> user.getUsername().equals(userName)).findFirst().orElse(null);

        if (userLog.getPassword().equals(password)) {
            return userLog;
        }
        return null;
    }

    public void tweetInfo(String tweetName) {
        Tweet tweet = tweets.stream().filter(t -> t.getName().equals(tweetName)).findFirst().orElse(null);
        if (tweet != null) {
            System.out.println(tweet.toString());
        } else System.out.println("нет твита под таким названием");
    }

    public void addLikeTweet(String tweetName, User user) {
        Tweet tweet = tweets.stream().filter(t -> t.getName().equals(tweetName)).findFirst().orElse(null);
        if (tweet != null) {
            tweet.like(user);
        } else System.out.println("нет такого твита");
    }

    public void unLikeTweet(String tweetName, User user) {
        Tweet tweet = tweets.stream().filter(t -> t.getName().equals(tweetName)).findFirst().orElse(null);
        if (tweet != null) {
            tweet.unlike(user);
        } else System.out.println("нет такого твита");
    }

    public void commentTweet(String tweetName, User user, String massage) {
        Tweet tweet = tweets.stream().filter(t -> t.getName().equals(tweetName)).findFirst().orElse(null);
        if (tweet != null) {
            tweet.reply(user, massage);
        } else System.out.println("нет такого твита");
    }

    public void displayFeed(User user) {
        user.getFollowing().stream().
                forEach(tweet -> tweet.getTweets().
                        forEach(tw -> System.out.println(tw)));
    }

    public void displayUserTweets(String userName) {
        User user = findUserByUsername(userName);
        System.out.println(user.toString());
        displayFeed(user);
    }

    public User findUserByUsername(String userName) {
        User user = users.stream()
                .filter(n -> n.getUsername().equals(userName)).findFirst().orElse(null);
        return user;
    }

    public void follow(String name, User user) {
        User us = users.stream().filter(n -> n.getUsername().equals(name)).findFirst().orElse(null);
        user.follow(us);
    }

    public void unFollow(String name, User user) {
        User us = users.stream().filter(n -> n.getUsername().equals(name)).findFirst().orElse(null);
        user.unFollow(us);
    }
    public void displayTweet() {
        for (Tweet tweet:tweets) {
            Thread thread= new Thread(()->{
                try {
                    System.out.println(tweet);
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }public void displayUserInfo(String user) {
        User us = findUserByUsername(user);
        if (us!=null){
            for (Tweet tweeet:us.getTweets()) {
                Thread thread= new Thread(()->{
                    try {
                        System.out.println(tweeet);
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                thread.start();
            }
        }else System.out.println("нет твитов или пользователя");
    }
}