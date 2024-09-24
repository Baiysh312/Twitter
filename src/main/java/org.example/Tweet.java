package org.example;

import java.util.ArrayList;
import java.util.List;

public class Tweet {
    private String content;
    private User author;

    public Tweet(String content, User author) {
        this.content = content;
        this.author = author;
    }

    List<RepliesTweet> replies = new ArrayList<>();
    List<User> likes = new ArrayList<>();

    public void reply(User user, String message)
    {
        replies.add(new RepliesTweet(user,message));
    }
    public void like(User user){
        if(likes.stream().anyMatch(us ->us.equals(user))){
            System.out.println("polzovatel uzhe laiknul");
        }else likes.add(user);
    }
    public void unlike(User user){
        if(likes.stream().anyMatch(us ->us.equals(user))){
            likes.remove(user);
        }
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "content='" + content + '\'' +
                ", author=" + author +
                '}';
    }
}