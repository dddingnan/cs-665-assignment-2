package edu.bu.met.cs665.observer;

import edu.bu.met.cs665.model.*;

public class Driver implements Observer {
    private String name;

    public Driver(String name) {
        this.name = name;
    }

    @Override
    public void update(DeliveryRequest deliveryRequest) {
        System.out.println("Driver " + name + " notified of new delivery request: " + deliveryRequest.getDescription());
    }
}
