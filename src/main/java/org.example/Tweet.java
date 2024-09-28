package org.example;

import java.util.ArrayList;
import java.util.List;

public class   Tweet {


    private String content;
    private User author;
    private List<Tweet> replies;
    private List<User> likes;

    public Tweet(String content, User author) {
        this.content = content;
        this.author = author;
        this.replies = new ArrayList<>();
        this.likes = new ArrayList<>();
    }




    public void reply(User user, String message) {
        Tweet reply = new Tweet(message, user);
        replies.add(reply);
    }

    public void like(User user) {
        if (!likes.contains(user)) {
            likes.add(user);
        }
    }

    public void unlike(User user) {
        if(likes.contains(user)) {
            likes.remove(user);
        }
    }

    @Override
    public String toString() {
        return author + ": " + content + " (Likes: " + likes.size() + ")";
    }

    public List<Tweet> getReplies() {
        return replies;
    }
}
