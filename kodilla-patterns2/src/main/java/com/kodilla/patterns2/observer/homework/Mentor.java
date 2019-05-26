package com.kodilla.patterns2.observer.homework;

public class Mentor implements ParticipantQueueObserver {

    private final int mentorId;
    private final String mentorName;
    private final String mentorSurname;
    private int taskCounter;

    public Mentor(int mentorId, String mentorName, String mentorSurname) {
        this.mentorId = mentorId;
        this.mentorName = mentorName;
        this.mentorSurname = mentorSurname;
    }

    @Override
    public void update(ParticipantQueue participantQueue) {
        System.out.println("New task made by: " + participantQueue.getParticipant().getParticipantName() + " " + participantQueue.getParticipant().getParticipantSurname()
        + ". Task name: " + participantQueue.getTasks().get(participantQueue.getTasks().size()-1).getName());
        taskCounter++;
    }

    public int getTaskCounter() {
        return taskCounter;
    }
}
