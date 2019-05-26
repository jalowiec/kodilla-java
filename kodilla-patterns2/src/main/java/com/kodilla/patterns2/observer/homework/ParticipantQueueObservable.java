package com.kodilla.patterns2.observer.homework;

public interface ParticipantQueueObservable {
    void registerObserver(ParticipantQueueObserver participantQueueObserver);
    void notifyObservers();
    void removeObserver(ParticipantQueueObserver participantQueueObserver);

}
