package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private final Integer userId;
    private final String  userName;
    private final Sex userSex;
    private final LocalDate userBirthDate;
    private final Integer postedPostNumber;

    public ForumUser(final Integer userId, final String userName, final Sex userSex, final LocalDate userBirthDate, final Integer postedPostNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userBirthDate = userBirthDate;
        this.postedPostNumber = postedPostNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Sex getUserSex() {
        return userSex;
    }

    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }

    public Integer getPostedPostNumber() {
        return postedPostNumber;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userBirthDate=" + userBirthDate +
                ", postedPostNumber=" + postedPostNumber +
                '}';
    }
}
