package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Twitter twitter = new Twitter();
        System.out.println("veedite typ operation:\n1- registration\n2-log in");
        int operation= scan.nextInt();
        switch (operation) {
            case 1:
                System.out.printf("vvedite name");
                String name = scan.next();
                System.out.printf("vvedite fullName");
                String fullName = scan.next();
                System.out.printf("vvedite password");
                String password = scan.next();
                User user = new User(name, fullName, password);
                twitter.addUser(user);
                break;
            case 2:
                twitter.login("aaa","aaa");
                System.out.printf("null");

                break;
        }
    }
}