package ru.hse.edu.myurachinskiy.sortings;

import ru.hse.edu.myurachinskiy.utils.AppSettings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class ExecutableMergeSort implements Runnable {
    private Random random = new Random();

    protected List<Integer> createRandomList() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < AppSettings.getRandomListSize(); ++i) {
            numbers.add(random.nextInt(AppSettings.getUpperBoundRandom()));
        }

        return numbers;
    }

    protected void saveTimeLog(String label, long duration) {
        System.out.println(label + ": " + duration);
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(AppSettings.FILE_NAME, true))) {
                writer.write(label + ": " + duration + "\n");
            }
        } catch (IOException exc) {
            System.out.println("Ca't write to file. Message: " + exc.getMessage());
        }
    }
}
