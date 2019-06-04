package ru.hse.edu.myurachinskiy;

import java.io.Serializable;
import java.util.List;

public class Message implements Serializable {

    private static final long serialVersionUID = 7487533781023034501L;

    private List<Integer> numbers;
    private long sentTime;

    public Message(List<Integer> numbers, long sentTime) {
        this.numbers = numbers;
        this.sentTime = sentTime;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public long getSentTime() {
        return sentTime;
    }

    public void setSentTime(long sentTime) {
        this.sentTime = sentTime;
    }
}
