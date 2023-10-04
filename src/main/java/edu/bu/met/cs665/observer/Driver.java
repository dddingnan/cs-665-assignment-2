package edu.bu.met.cs665.observer;

import edu.bu.met.cs665.model.*;

public class Driver implements Observer {
    private int id;
    private String name;
    private boolean isAvailable;

    public Driver(int id, String name, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.isAvailable = isAvailable;
    }

    @Override
    public void update(DeliveryRequest deliveryRequest) {
        if (isAvailable()) {
            System.out.println("Driver [ID: " + id + ", Name: " + name + "] notified of a new delivery request:");
            System.out.println("Description: " + deliveryRequest.getDescription());
            System.out.println("Product Name: " + deliveryRequest.getProductName());
            System.out.println("Pick-up Address: " + deliveryRequest.getPickupAddress());
            System.out.println("Destination Address: " + deliveryRequest.getDestinationAddress());
            System.out.println("Customer Name: " + deliveryRequest.getCustomerName());
            System.out.println("Customer Contact: " + deliveryRequest.getCustomerContact());
            System.out.println("--------------------------------------------------------");
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
