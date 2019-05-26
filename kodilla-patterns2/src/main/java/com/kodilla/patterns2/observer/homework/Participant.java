package com.kodilla.patterns2.observer.homework;

public class Participant {

    private int participantId;
    private String participantName;
    private String participantSurname;

    public Participant(int participantId, String participantName, String participantSurname) {
        this.participantId = participantId;
        this.participantName = participantName;
        this.participantSurname = participantSurname;
    }

    public String getParticipantName() {
        return participantName;
    }

    public String getParticipantSurname() {
        return participantSurname;
    }
}
