package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParticipantQueueTestSuite {

    @Test
    public void testUpdate() {
        //Given
        Mentor andrzejJaromin = new Mentor(1, "Andrzej", "Jaromin");
        Mentor mateuszLach = new Mentor(2, "Mateusz", "Lach");
        Participant adamNowak = new Participant(1, "Adam", "Nowak");
        Participant filipMatusiak = new Participant(2, "Filip", "Matusiak");
        Participant aleksandraRadzikowska = new Participant(3, "Aleksandra", "Radzikowska");
        Participant lukaszMadej = new Participant(4, "Lukasz", "Madej");
        ParticipantQueue participantQueue1 = new ParticipantQueue(adamNowak);
        ParticipantQueue participantQueue2 = new ParticipantQueue(filipMatusiak);
        ParticipantQueue participantQueue3 = new ParticipantQueue(aleksandraRadzikowska);
        ParticipantQueue participantQueue4 = new ParticipantQueue(lukaszMadej);
        participantQueue1.registerObserver(andrzejJaromin);
        participantQueue2.registerObserver(andrzejJaromin);
        participantQueue3.registerObserver(andrzejJaromin);
        participantQueue4.registerObserver(mateuszLach);
        participantQueue4.registerObserver(andrzejJaromin);

        //When
        participantQueue1.addTask(new Task("Task one", "Task one description"));
        participantQueue2.addTask(new Task("Task one", "Task one description"));
        participantQueue1.addTask(new Task("Task two", "Task two description"));
        participantQueue3.addTask(new Task("Task one", "Task one description"));


        //Then
        assertEquals(2, participantQueue1.getTasks().size());
        assertEquals(1, participantQueue2.getTasks().size());
        assertEquals(1, participantQueue3.getTasks().size());
        assertEquals(0, participantQueue4.getTasks().size());
        assertEquals(4, andrzejJaromin.getTaskCounter());
        assertEquals(0, mateuszLach.getTaskCounter());


    }
}
