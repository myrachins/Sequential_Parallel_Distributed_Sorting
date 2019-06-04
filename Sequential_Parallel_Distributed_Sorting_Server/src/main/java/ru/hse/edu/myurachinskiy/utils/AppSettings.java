package ru.hse.edu.myurachinskiy.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppSettings {
    private AppSettings() { }

    private static Random random = new Random();

    public static final String FILE_NAME = "docs/results.txt";

    private static int randomListSize;
    private static int upperBoundRandom;
    private static List<Integer> randomList;

    public synchronized static int getRandomListSize() {
        return randomListSize;
    }

    public synchronized static void setRandomListSize(int randomListSize) {
        AppSettings.randomListSize = randomListSize;
    }

    public synchronized static int getUpperBoundRandom() {
        return upperBoundRandom;
    }

    public synchronized static void setUpperBoundRandom(int upperBoundRandom) {
        AppSettings.upperBoundRandom = upperBoundRandom;
    }

    public synchronized static void generateRandomList() {
        randomList = new ArrayList<>();

        for (int i = 0; i < getRandomListSize(); ++i) {
            randomList.add(random.nextInt(getUpperBoundRandom() + 1));
        }
    }

    public synchronized static List<Integer> getRandomList() {
        return randomList;
    }
}
