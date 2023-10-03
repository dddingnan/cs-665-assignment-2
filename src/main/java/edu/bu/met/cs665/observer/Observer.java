package edu.bu.met.cs665.observer;

import edu.bu.met.cs665.model.*;

// Observer Interface
public interface Observer {
    void update(DeliveryRequest deliveryRequest);

    boolean isAvailable();

    void setAvailability(boolean availability);

    String getName();
}
