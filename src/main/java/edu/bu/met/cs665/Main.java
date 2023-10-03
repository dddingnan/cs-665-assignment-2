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

import java.util.ArrayList;
import java.util.List;

import edu.bu.met.cs665.loader.FileLoader;
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
    FileLoader loader = new FileLoader();
    List<Driver> drivers = new ArrayList<>();
    drivers = loader.loadDriverFile("src/data/driver.csv");

    for (Driver driver : drivers) {
      shop.registerObserver(driver);
    }

    System.out.println("New Order Request: " + "New delivery for downtown");
    System.out.println("--------------------------------------------------------");
    // Broadcast a delivery request
    DeliveryRequest request = new DeliveryRequest("New delivery for downtown");
    shop.newDeliveryRequest(request);
    System.out.println("--------------------------------------------------------");
    // Remove the last driver from the list of drivers
    Driver lastDriver = drivers.remove(drivers.size() - 1);
    shop.removeObserver(lastDriver);

    System.out.println("Removed the last driver: " + lastDriver.getName());
    System.out.println("--------------------------------------------------------");

    // Send a new order request after removing the last driver
    System.out.println("New Order Request: " + "Another delivery for uptown");
    System.out.println("--------------------------------------------------------");
    DeliveryRequest newRequest = new DeliveryRequest("Another delivery for uptown");
    shop.newDeliveryRequest(newRequest);
    System.out.println("--------------------------------------------------------");

  }
}
