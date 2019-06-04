package ru.hse.edu.myurachinskiy;

import java.io.Serializable;
import java.util.List;

public class ResponseMessage implements Serializable {

    private static final long serialVersionUID = 4710018312843325430L;

    private List<Integer> numbers;
    private long sentTime;
    private long sortingDuration;
    private long sendingDuration;

    public ResponseMessage(List<Integer> numbers, long sentTime, long sortingDuration, long sendingDuration) {
        this.numbers = numbers;
        this.sentTime = sentTime;
        this.sortingDuration = sortingDuration;
        this.sendingDuration = sendingDuration;
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

    public long getSortingDuration() {
        return sortingDuration;
    }

    public void setSortingDuration(long sortingDuration) {
        this.sortingDuration = sortingDuration;
    }

    public long getSendingDuration() {
        return sendingDuration;
    }

    public void setSendingDuration(long sendingDuration) {
        this.sendingDuration = sendingDuration;
    }
}
