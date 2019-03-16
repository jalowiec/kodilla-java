package com.kodilla.good.patterns.challenges.ProductOrder;

public class User {
    private String userName;
    private String userSurname;
    private int userId;

    public User(String userName, String userSurname, int userId) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public int getUserId() {
        return userId;
    }
}
