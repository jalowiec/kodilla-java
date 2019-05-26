package com.kodilla.patterns2.observer.homework;


import java.util.ArrayList;
import java.util.List;

public class ParticipantQueue implements ParticipantQueueObservable {

    private final List<ParticipantQueueObserver> participantQueueObservers;
    private final List<Task> tasks;
    private final Participant participant;

    public ParticipantQueue(Participant participant) {
        participantQueueObservers = new ArrayList<>();
        tasks = new ArrayList<>();
        this.participant = participant;
    }

    public void addTask(Task task){
        tasks.add(task);
        notifyObservers();
    }


    @Override
    public void registerObserver(ParticipantQueueObserver participantQueueObserver) {
        participantQueueObservers.add(participantQueueObserver);


    }

    @Override
    public void notifyObservers() {
        for(ParticipantQueueObserver participantQueueObserver : participantQueueObservers){
            participantQueueObserver.update(this);
        }



    }

    @Override
    public void removeObserver(ParticipantQueueObserver participantQueueObserver) {
        participantQueueObservers.remove(participantQueueObserver);

    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Participant getParticipant() {
        return participant;
    }
}
