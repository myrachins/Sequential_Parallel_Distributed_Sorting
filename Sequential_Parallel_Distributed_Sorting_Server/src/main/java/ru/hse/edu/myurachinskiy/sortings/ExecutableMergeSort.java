package ru.hse.edu.myurachinskiy.sortings;

import ru.hse.edu.myurachinskiy.utils.AppSettings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class ExecutableMergeSort implements Runnable {

    protected void saveTimeLog(String label, long duration) {
        System.out.println(label + ": " + duration);
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(AppSettings.FILE_NAME, true))) {
                writer.write(label + " = " + duration + "\n");
            }
        } catch (IOException exc) {
            System.out.println("Can't write to file. Message: " + exc.getMessage());
        }
    }
}
