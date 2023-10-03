package edu.bu.met.cs665.observer;

import edu.bu.met.cs665.model.*;

public class Driver implements Observer {
    private String name;
    private boolean isAvailable;

    public Driver(String name, boolean isAvailable) {
        this.name = name;
        this.isAvailable = isAvailable;
    }

    @Override
    public void update(DeliveryRequest deliveryRequest) {
        if (isAvailable()) {
            System.out.println(
                    "Driver " + name + " notified of new delivery request: " + deliveryRequest.getDescription());
        } else {
            System.out.println("Driver " + name + " is currently unavailable for deliveries.");
        }
    }

    /**
     * Returns the name of the driver.
     *
     * @return The name of the driver.
     */
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }
}
