package ru.hse.edu.myurachinskiy.sortings;

import ru.hse.edu.myurachinskiy.MergeSort;
import ru.hse.edu.myurachinskiy.Message;
import ru.hse.edu.myurachinskiy.ResponseMessage;
import ru.hse.edu.myurachinskiy.Timer;
import ru.hse.edu.myurachinskiy.utils.AppSettings;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class SocketBasedMergeSort extends ExecutableMergeSort  {

    @Override
    public void run() {
        MergeSort sort = new MergeSort();
        Timer mergeTimer = new Timer();
        Timer leftPartTimer = new Timer();
        final SortResult result = new SortResult();

        List<Integer> leftPart = getLeftPart();
        List<Integer> rightPart = getRightPart();

        try {
            ServerSocket server = new ServerSocket(AppSettings.getServerPort());

            System.out.println("Waiting to client be online...");

            long commonStartTime = System.nanoTime(); // common sorting start

            try (Socket socket = server.accept()) {
                ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

                Thread clientThread = new Thread(() -> {
                    try {
                        os.writeObject(new Message(rightPart, System.nanoTime()));
                        result.responseMessage = (ResponseMessage) is.readObject();
                    } catch (IOException exc) {
                        System.out.println("Error with server. Message: " + exc.getMessage());
                    } catch (ClassNotFoundException exc) {
                        System.out.println("Unknown type of message. Message: " + exc.getMessage());
                    }
                });

                clientThread.start(); // starting waiting for sorted right part
                leftPartTimer.setStrategy(() -> result.leftPart = sort.sortList(leftPart)); // sorting left part
                long leftDuration = leftPartTimer.testStrategy();

                clientThread.join();

                if (result.responseMessage == null) {
                    System.out.println("Can't get response from client");
                    return;
                }

                long receiveTime = System.nanoTime();

                mergeTimer.setStrategy(() -> sort.mergeLists(result.leftPart, result.responseMessage.getNumbers())); // merging lists
                long mergeDuration = mergeTimer.testStrategy();
                long commonEndTime = System.nanoTime();

                saveTimeLog("Part 1: sorting time", leftDuration);
                saveTimeLog("Part 2: sorting time", result.responseMessage.getSortingDuration());
                saveTimeLog("Sorted combining time", mergeDuration);
                saveTimeLog("Total sorting time", commonEndTime - commonStartTime);

                saveTimeLog("From Main to Client sending duration", result.responseMessage.getSendingDuration());
                saveTimeLog("From Client to Main sending duration", receiveTime - result.responseMessage.getSentTime());
            }
        } catch (IOException exc) {
            System.out.println("Error with server. Message: " + exc.getMessage());
        } catch (InterruptedException exc) {
            System.out.println("Error with threads. Message: " + exc.getMessage());
        }
    }

    private class SortResult {
        List<Integer> leftPart;
        ResponseMessage responseMessage;
    }
}
