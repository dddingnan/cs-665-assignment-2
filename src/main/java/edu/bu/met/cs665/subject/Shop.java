package edu.bu.met.cs665.subject;

import java.util.ArrayList;
import java.util.List;
import edu.bu.met.cs665.observer.*;
import edu.bu.met.cs665.model.*;

public class Shop implements Subject {
    private List<Observer> observers;
    private DeliveryRequest deliveryRequest;

    public Shop() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(deliveryRequest);
        }
    }

    public void newDeliveryRequest(DeliveryRequest request) {
        this.deliveryRequest = request;
        notifyObservers();
    }
}
