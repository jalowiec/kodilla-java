package com.kodilla.patterns2.observer.forum;

import java.util.ArrayList;
import java.util.List;

public class ForumTopic implements ForumObservable {
    private final List<ForumObserver> forumObservers;
    private final List<String> messages;
    private final String name;

    public ForumTopic(String name) {
        forumObservers = new ArrayList<>();
        messages = new ArrayList<>();
        this.name = name;
    }

    public void addPost(String post){
        messages.add(post);
        notifyObservers();
    }

    @Override
    public void registerObserver(ForumObserver forumObserver) {
        forumObservers.add(forumObserver);
    }

    @Override
    public void notifyObservers() {
        for(ForumObserver forumObserver : forumObservers){
            forumObserver.update(this);
        }

    }

    @Override
    public void removeObserver(ForumObserver forumObserver) {

    }

    public List<String> getMessages() {
        return messages;
    }

    public String getName() {
        return name;
    }
}
