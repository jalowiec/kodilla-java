package com.kodilla.patterns2.observer.forum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForumUserTestSuite {

    @Test
    public void testUpdate(){
        //Given
        ForumTopic javaHelpForumTopic = new JavaHelpForumTopic();
        ForumTopic javaToolsForumTopic = new JavaToolsForumTopic();
        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser ivoneEscobar = new ForumUser("Ivone Escobar");
        ForumUser jassiePinkman = new ForumUser("Jassie Pinkman");
        javaHelpForumTopic.registerObserver(johnSmith);
        javaToolsForumTopic.registerObserver(ivoneEscobar);
        javaHelpForumTopic.registerObserver(jassiePinkman);
        javaToolsForumTopic.registerObserver(jassiePinkman);

        //When
        javaHelpForumTopic.addPost("Post 1 Java Help");
        javaHelpForumTopic.addPost("Post 2 Java Help");
        javaToolsForumTopic.addPost("Post 1 Java Tools");
        javaHelpForumTopic.addPost("Post 3 Java Help");
        javaToolsForumTopic.addPost("Post 2 Java Tools");

        //Then
        assertEquals(3, johnSmith.getUpdateCount());
        assertEquals(2, ivoneEscobar.getUpdateCount());
        assertEquals(5, jassiePinkman.getUpdateCount());


    }
}
