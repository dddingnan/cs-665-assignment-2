/**
 * Name: Dingnan Hsu
 * Course: CS-665 Software Designs & Patterns
 * Date: 09/21/2023
 * File Name: FileLoader.java
 * Description: The FileLoader class provides utility functions to read beverage and condiment data from CSV files.
 * Each method is loading data from a provided file and returning a list of corresponding objects.
 */

package edu.bu.met.cs665.loader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.bu.met.cs665.observer.*;
import edu.bu.met.cs665.InvalidDataException;

public class FileLoader {

    public String line = "";
    public String splitBy = ",";

    /**
     * Loads drivers data from a given CSV file.
     * The CSV file format: "<driver_name>,<is_available>".
     *
     * @param fileName Name of the file to be read.
     * @return A list of Driver objects.
     * @throws FileNotFoundException If the file does not exist.
     * @throws IOException           If an error occurs while reading the file.
     * @throws InvalidDataException  If data in the file is invalid.
     */
    public List<Driver> loadDriverFile(String fileName) throws InvalidDataException {
        List<Driver> drivers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Split the line by commas
                if (data.length < 2) {
                    System.out.println("Invalid data format: " + line);
                    continue; // Skip this line and continue with the next line
                }
                String name = data[0];
                boolean isAvailable = Boolean.parseBoolean(data[1].trim()); // Convert the string to a boolean
                drivers.add(new Driver(name, isAvailable));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return new ArrayList<>(); // Return an empty list if file not found
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return new ArrayList<>(); // Return an empty list in case of IO errors
        }

        return drivers;
    }

}
