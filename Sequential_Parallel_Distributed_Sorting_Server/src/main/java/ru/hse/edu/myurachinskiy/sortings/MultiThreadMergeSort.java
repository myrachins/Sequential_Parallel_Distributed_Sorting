package ru.hse.edu.myurachinskiy.sortings;

import ru.hse.edu.myurachinskiy.MergeSort;
import ru.hse.edu.myurachinskiy.Timer;
import ru.hse.edu.myurachinskiy.utils.AppSettings;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadMergeSort extends ExecutableMergeSort {

    @Override
    public void run() {
        MergeSort sort = new MergeSort();
        Timer leftPartTimer = new Timer();
        Timer rightPartTimer = new Timer();
        Timer mergeTimer = new Timer();
        final SortResult result = new SortResult();

        List<Integer> randomNumbers = AppSettings.getRandomList();
        List<Integer> leftPart = new ArrayList<>(randomNumbers.subList(0, randomNumbers.size() / 2));
        List<Integer> rightPart = new ArrayList<>(randomNumbers.subList(randomNumbers.size() / 2, randomNumbers.size()));

        leftPartTimer.setStrategy(() -> result.leftPart = sort.sortList(leftPart));
        rightPartTimer.setStrategy(() -> result.rightPart = sort.sortList(rightPart));

        long commonStartTime = System.nanoTime(); // common sorting start
        Thread rightPartThread = new Thread(() -> result.rightPartDuration = rightPartTimer.testStrategy());
        rightPartThread.start(); // sorting right part in new thread
        long leftDuration = leftPartTimer.testStrategy(); // sorting left part in current Thread

        try {
            rightPartThread.join();
            mergeTimer.setStrategy(() -> sort.mergeLists(result.leftPart, result.rightPart)); // merging lists
            long mergeDuration = mergeTimer.testStrategy();
            long commonEndTime = System.nanoTime();

            saveTimeLog("Part 1: sorting time", leftDuration);
            saveTimeLog("Part 1: sorting time", result.rightPartDuration);
            saveTimeLog("Sorted combining time", mergeDuration);
            saveTimeLog("Total sorting time", commonEndTime - commonStartTime);
        } catch (InterruptedException exc) {
            System.out.println("Error with second thread. Message: " + exc.getMessage());
        }
    }

    private class SortResult {
        List<Integer> leftPart;
        List<Integer> rightPart;
        long rightPartDuration;
    }
}
