package ru.hse.edu.myurachinskiy;

import ru.hse.edu.myurachinskiy.sortings.MultiThreadMergeSort;
import ru.hse.edu.myurachinskiy.sortings.OrdinaryMergeSort;
import ru.hse.edu.myurachinskiy.sortings.SocketBasedMergeSort;
import ru.hse.edu.myurachinskiy.utils.AppSettings;

import java.util.ArrayList;
import java.util.List;

public class MainServer {
    public static void main(String[] args) {
        try {
            parseArguments(args);
        } catch (Exception exc) {
            System.out.println("Invalid input parameters. Message: " + exc.getMessage());
            return;
        }
        List<Runnable> tasks = createSortingList();
        for(Runnable task : tasks) {
            task.run();
            System.out.println("\n" + "---------" + "\n");
        }
        System.out.println("All tasks have been completed");
    }

    private static List<Runnable> createSortingList() {
        List<Runnable> algorithms = new ArrayList<>();
        algorithms.add(new OrdinaryMergeSort());
        algorithms.add(new MultiThreadMergeSort());
        algorithms.add(new SocketBasedMergeSort());

        return algorithms;
    }

    private static void parseArguments(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Number of parameters should be 4");
        }
        try {
            AppSettings.setRandomListSize(Integer.parseInt(args[0]) * 2);
            AppSettings.setUpperBoundRandom(Integer.parseInt(args[1]));
            AppSettings.setInetAddress(args[2]);
            AppSettings.setServerPort(Integer.parseInt(args[3]));
            if (AppSettings.getRandomListSize() <= 0 || AppSettings.getUpperBoundRandom() <= 0) {
                throw new IllegalArgumentException("List size and upper bound for random should be more than 0");
            }
            AppSettings.generateRandomList();
        } catch (NumberFormatException exc) {
            throw new IllegalArgumentException("Can't parse param: " + exc.getMessage());
        }
    }
}
