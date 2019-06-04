package ru.hse.edu.myurachinskiy;

import ru.hse.edu.myurachinskiy.sortings.OrdinaryMergeSort;
import ru.hse.edu.myurachinskiy.utils.AppSettings;

import java.util.ArrayList;
import java.util.List;

public class Main {
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
        }
        System.out.println("All tasks have been completed");
    }

    private static List<Runnable> createSortingList() {
        List<Runnable> algorithms = new ArrayList<>();
        algorithms.add(new OrdinaryMergeSort());

        return algorithms;
    }

    private static void parseArguments(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Number of parameters should be 2");
        }
        try {
            AppSettings.setN(Integer.parseInt(args[0]));
            AppSettings.setM(Integer.parseInt(args[1]));
        } catch (NumberFormatException exc) {
            throw new IllegalArgumentException("Can't parse param: " + exc.getMessage());
        }
    }
}
