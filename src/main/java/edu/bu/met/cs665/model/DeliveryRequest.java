package edu.bu.met.cs665.model;

public class DeliveryRequest {
    private String description;

    public DeliveryRequest(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    // TODO Contains details about the product delivery, such as what needs to be
    // delivered, destination, etc.
}
