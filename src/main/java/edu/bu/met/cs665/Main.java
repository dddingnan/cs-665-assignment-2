/**
 * Name: Dingnan Hsu
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/03/2023
 * File Name: Main.java
 * Description: 
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.observer.*;
import edu.bu.met.cs665.subject.*;
import edu.bu.met.cs665.model.*;

/**
 * This is the Main class.
 */
public class Main {

  /**
   * Entry point method for the application. This method initializes the system by
   */
  public static void main(String[] args) throws InvalidDataException, InterruptedException {
    Shop shop = new Shop();
    // Register 5 driver observers
    Driver driver1 = new Driver("John");
    Driver driver2 = new Driver("Jane");
    Driver driver3 = new Driver("Doe");
    Driver driver4 = new Driver("Alice");
    Driver driver5 = new Driver("Bob");

    shop.registerObserver(driver1);
    shop.registerObserver(driver2);
    shop.registerObserver(driver3);
    shop.registerObserver(driver4);
    shop.registerObserver(driver5);

    System.out.println("New Order Request: " + "New delivery for downtown");
    System.out.println("--------------------------------------------------------");
    // Broadcast a delivery request
    DeliveryRequest request = new DeliveryRequest("New delivery for downtown");
    shop.newDeliveryRequest(request);
    System.out.println("--------------------------------------------------------");
    // TODO Add delete last one driver and sent a new order request again
  }
}
