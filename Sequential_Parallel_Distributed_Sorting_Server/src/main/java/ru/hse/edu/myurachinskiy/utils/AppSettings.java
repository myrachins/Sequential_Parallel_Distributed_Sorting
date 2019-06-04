package ru.hse.edu.myurachinskiy.utils;

public class AppSettings {
    private AppSettings() { }

    public static final String FILE_NAME = "docs/results.txt";

    private static int randomListSize;
    private static int upperBoundRandom;

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
}
