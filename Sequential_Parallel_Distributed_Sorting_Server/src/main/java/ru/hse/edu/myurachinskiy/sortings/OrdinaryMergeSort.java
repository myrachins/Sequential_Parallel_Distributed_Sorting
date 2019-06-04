package ru.hse.edu.myurachinskiy.sortings;

import ru.hse.edu.myurachinskiy.MergeSort;
import ru.hse.edu.myurachinskiy.Timer;

import java.util.List;

public class OrdinaryMergeSort extends ExecutableMergeSort {

    public void run() {
        MergeSort sort = new MergeSort();
        Timer timer = new Timer();
        List<Integer> randomNumbers = createRandomList();

        timer.setStrategy(() -> sort.sortList(randomNumbers));
        long duration = timer.testStrategy();

        saveTimeLog("Sequential sorting time", duration);
    }
}
