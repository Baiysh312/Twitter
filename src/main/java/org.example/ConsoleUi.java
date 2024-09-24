package org.example;

public class ConsoleUi {

    void displayMenu() {
        System.out.println();
    }

    void displayTweet(Tweet tweet) {
        System.out.println(tweet.toString());
    }

    void displayUserInfo(User user) {
        System.out.println(user.toString());
    }
}
