package org.example;

import java.util.ArrayList;
import java.util.List;

public class Twitter {
    private List<Tweet> tweets;

    public Twitter() {
        tweets = new ArrayList<>();
    }

    public void postTweet(User user, String message) {
        tweets.add(new Tweet(message, user));
    }

    public void displayTweets() {
        if (tweets.isEmpty()) {
            System.out.println("Нет твитов.");
        } else {
            for (Tweet tweet : tweets) {
                System.out.println(tweet);
                for (Tweet reply : tweet.getReplies()) {
                    System.out.println("  -> " + reply);
                }
            }
        }   }
}
