package com.kodilla.testing.forum.statistics;

public class StatisticsCounter {
    private int usersNumber;
    private int postsNumber;
    private int commentsNumber;
    private double postsPerUserAvgNumber;
    private double commentsPerUserAvgNumber;
    private double commentsPerPostAvgNumber;

    public int getUsersNumber() {
        return usersNumber;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    public int getCommentsNumber() {
        return commentsNumber;
    }

    public double getPostsPerUserAvgNumber() {
        return postsPerUserAvgNumber;
    }

    public double getCommentsPerUserAvgNumber() {
        return commentsPerUserAvgNumber;
    }

    public double getCommentsPerPostAvgNumber() {
        return commentsPerPostAvgNumber;
    }

    public void calculateAdvStatistics(Statistics statistics){
        int usersNumber = statistics.usersNames().size();
        int postsNumber = statistics.postsCount();
        int commentsNumber = statistics.commentsCount();
        this.usersNumber = usersNumber;
        this.postsNumber = postsNumber;
        this.commentsNumber = commentsNumber;

        if(usersNumber!=0){
            postsPerUserAvgNumber = (double) postsNumber / usersNumber;
            commentsPerUserAvgNumber = (double) commentsNumber / usersNumber;
        } else{
            postsPerUserAvgNumber = 0;
            commentsPerUserAvgNumber = 0;
        }

        if(postsNumber != 0){
            commentsPerPostAvgNumber = (double) commentsNumber / postsNumber;
        } else {
            commentsPerPostAvgNumber = 0;
        }

    }
    public void showStatistics(){
        System.out.println("Statystyki:");
        System.out.println("liczba użytkownikow: " + usersNumber);
        System.out.println("liczba postow: " + postsNumber);
        System.out.println("liczba komentarzy: " + commentsNumber);
        System.out.println("srednia liczba postow na uzytkownika: "+ postsPerUserAvgNumber);
        System.out.println("srednia liczba komentarzy na uzytkownika: " + commentsPerUserAvgNumber);
        System.out.println("srednia liczba komentarzy na post: " + commentsPerPostAvgNumber);


    }


}
