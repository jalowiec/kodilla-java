package com.kodilla.patterns.strategy.social;

public class User {
    private String userName;
    SocialPublisher socialPublisher;

    public User(String userName) {
        this.userName = userName;
    }

    public String sharePost(){
        return socialPublisher.share();
    }

    public void changeSocialMedium(SocialPublisher socialPublisher){
        this.socialPublisher = socialPublisher;
    }
}
