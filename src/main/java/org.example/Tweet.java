package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Tweet {
    private String name;
    private String content;
    private User author;

    List<RepliesTweet> replies = new ArrayList<>();
    List<User> likes = new ArrayList<>();


    public Tweet(String name,String content, User author) {
        this.name = name;
        this.content = content;
        this.author = author;
    }


    public void reply(User user, String message) {
        replies.add(new RepliesTweet(user,message));
    }
    public void like(User user){
        if(likes.stream().anyMatch(us ->us.equals(user))){
            System.out.println("Этот пост уже лайкнут");
        }else likes.add(user);
    }
    public void unlike(User user){
        if(likes.stream().anyMatch(us ->us.equals(user))){
            likes.remove(user);
        }else System.out.println("пост не был лайкнут");
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", replies=" + replies +
                ", likes=" + likes +
                '}';
    }
}