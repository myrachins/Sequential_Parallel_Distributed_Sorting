package ru.hse.edu.myurachinskiy;

import org.junit.jupiter.api.Test;
import ru.hse.edu.myurachinskiy.Timer;

class TimerTest {

    @Test
    void testTimer() {
        Timer timer = new Timer();
        timer.setStrategy(() -> {
            for (int i = 0; i < 100000; ++i) { }
        });

        System.out.println(timer.testStrategy());

    }
}
