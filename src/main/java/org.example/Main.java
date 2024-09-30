package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User useR= new User("aaaa","aaaa","aaaa");
        User userR= new User();
        Scanner scan = new Scanner(System.in);
        Twitter twitter = new Twitter();
        twitter.addUser(useR);
        System.out.println(twitter.getUsers());
        while (true) {
            System.out.println("Выберите тип операции:\n" +
                    "1- регистрация\n" +
                    "2- войти в аккаунт");
            int operation = scan.nextInt();
            switch (operation) {
                case 1:
                    System.out.printf("введите имя пользователя");
                    String name = scan.next();
                    System.out.printf("введите фамилию ползователя");
                    String fullName = scan.next();
                    System.out.printf("введите пароль");
                    String password = scan.next();
                    User user = new User(name, fullName, password);
                    twitter.addUser(user);
                    continue;
                case 2:
                    System.out.println("введите имя пользователя для входа");
                    String logName = scan.next();
                    System.out.println("введите пароль");
                    String logPassword = scan.next();
                    User user1 = twitter.login(logName, logPassword);
                    if (user1 != null) {
                        System.out.println("Вы в главном меню\n" +
                                "Выберите действие:\n" +
                                "1- действие с твитами\n" +
                                "2- действие с подписчиками\n" +
                                "0- главное меню");
                        int operand = scan.nextInt();
                        if (operand == 1) {
                            System.out.println("1- добавить твит\n" +
                                    "2- посмотреть твит\n" +
                                    "3- лайкнуть твит\n" +
                                    "4- убрать лайк\n" +
                                    "5- написать коментарии");
                            int tweetCount= scan.nextInt();
                            switch (tweetCount){
                                case 1:
                                {System.out.println("введите название твита");
                                    String nameTweet= scan.next();
                                    System.out.println("введите пост(текст)");
                                    String tweetPost= scan.next();
                                    twitter.addTweet(new Tweet(nameTweet,tweetPost,user1));
                                    continue;
                                }
                                case 2:{
                                    System.out.println("введите название твита");
                                    String tweetName= scan.next();
                                    twitter.tweetInfo(tweetName);
                                    continue;
                                }
                                case 3: {
                                    System.out.println("введите название твита для лайка");
                                    String nameLikeTweet = scan.next();
                                    twitter.addLikeTweet(nameLikeTweet, user1);
                                    continue;
                                }
                                case 4:{
                                    System.out.println("введите название твита для удаления лайка");
                                    String nameUnLikeTweet=scan.next();
                                    twitter.unLikeTweet(nameUnLikeTweet,user1);
                                    continue;
                                }
                                case 5:{
                                    System.out.println("введите название твита для комментарии");
                                    String tweetNameComment= scan.next();
                                    System.out.println("напишите комментарии");
                                    String comment= scan.next();
                                    twitter.commentTweet(tweetNameComment,user1,comment);
                                }
                            }
                        } else if (operand == 2) {
                            System.out.println("1- подписаться на пользователя\n" +
                                    "2- отписаться от пользователя\n" +
                                    "3- посмотреть твиты пользователя\n" +
                                    "4- вывести все твиты\n" +
                                    "5- вывести твиты определенного пользователя\n" +
                                    "0- главное меню");
                            int followCount=scan.nextInt();
                            switch (followCount){
                                case 1:{
                                    System.out.println("введите имя пользователя для подписки");
                                    String nameFoll=scan.next();
                                    twitter.follow(nameFoll,user1);
                                }
                                case 2:{
                                    System.out.println("введите имя пользователя для отписки");
                                    String nameFoll=scan.next();
                                    twitter.unFollow(nameFoll,user1);
                                }
                                case 3:{
                                    System.out.println("введите имя пользователя для просмотра твитов");
                                    String nameInfo=scan.next();
                                    twitter.displayUserTweets(nameInfo);
                                } case 4:{
                                    twitter.displayTweet();
                                } case 5:{
                                    System.out.println("введите имя пользователя для просмотра твитов");
                                    String nameUs= scan.next();
                                    twitter.displayUserTweets(nameUs);
                                }
                            }
                        } else continue;
                    }

                    continue;
            }
        }
    }
}