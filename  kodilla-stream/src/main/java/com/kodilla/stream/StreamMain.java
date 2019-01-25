package com.kodilla.stream;


import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.forumuser.Sex;

import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class StreamMain {
    public static void main(String[] args) {

        Forum forum = new Forum();
        Map<Integer, ForumUser> resultMap =  forum.getForumUserList()
                .stream()
                .filter(forumUser -> forumUser.getUserSex()==Sex.M)
                .filter(forumUser -> Period.between(forumUser.getUserBirthDate(), LocalDate.now()).getYears() > 20)
                .filter(forumUser -> forumUser.getPostedPostNumber()>0)
                .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));

        System.out.println(resultMap);
    }
}