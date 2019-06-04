package ru.hse.edu.myurachinskiy.utils;

public class AppSettings {
    private AppSettings() { }

    public static final String FILE_NAME = "results.txt";

    private static int n;
    private static int m;

    public synchronized static int getN() {
        return n;
    }

    public synchronized static void setN(int n) {
        AppSettings.n = n;
    }

    public synchronized static int getM() {
        return m;
    }

    public synchronized static void setM(int m) {
        AppSettings.m = m;
    }
}
