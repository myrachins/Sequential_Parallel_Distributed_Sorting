package ru.hse.edu.myurachinskiy;

import ru.hse.edu.myurachinskiy.utils.AppSettings;
import ru.hse.edu.myurachinskiy.utils.MergeSortClient;

public class Main {
    public static void main(String[] args) {
        try {
            parseArguments(args);
        } catch (Exception exc) {
            System.out.println("Invalid input parameters. Message: " + exc.getMessage());
            return;
        }
        MergeSortClient client = new MergeSortClient();
        client.processRequest(); // waiting just for one connection
    }

    private static void parseArguments(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Number of parameters should be 2");
        }
        try {
            AppSettings.setServerInetAddress(args[0]);
            AppSettings.setServerPort(Integer.parseInt(args[1]));
        } catch (NumberFormatException exc) {
            throw new IllegalArgumentException("Can't parse param: " + exc.getMessage());
        }
    }
}
