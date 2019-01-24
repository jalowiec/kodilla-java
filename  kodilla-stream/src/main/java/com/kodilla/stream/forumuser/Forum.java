package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

final public class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum() {
        forumUserList.add(new ForumUser(1, "Kowalski Jan", Sex.M, LocalDate.of(1976, 9, 9), 100));
        forumUserList.add(new ForumUser(2, "Nowak Adam", Sex.M, LocalDate.of(2002, 1, 1), 10));
        forumUserList.add(new ForumUser(3, "Flis Alicja", Sex.F, LocalDate.of(2000, 2, 2), 0));
        forumUserList.add(new ForumUser(3, "Oczko Kamil", Sex.M, LocalDate.of(2000, 2, 2), 0));

    }
    public List<ForumUser> getForumUserList(){
        return new ArrayList<>(forumUserList);
    }
}
