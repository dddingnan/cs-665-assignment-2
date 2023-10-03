package edu.bu.met.cs665.subject;

import edu.bu.met.cs665.observer.*;

// Subject Interface
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
