package ru.hse.edu.myurachinskiy.utils;

import ru.hse.edu.myurachinskiy.MergeSort;
import ru.hse.edu.myurachinskiy.Message;
import ru.hse.edu.myurachinskiy.ResponseMessage;
import ru.hse.edu.myurachinskiy.Timer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class MergeSortClient {

    public void processRequest() {
        MergeSort sort = new MergeSort();
        Timer sortingTimer = new Timer();
        final SortResult result = new SortResult();

        try {
            try(Socket socket = new Socket(AppSettings.getServerInetAddress(), AppSettings.getServerPort())) {
                ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());

                Message requestMessage = (Message) is.readObject();
                long receiveTime = System.nanoTime();
                System.out.println("Client: Message has been gotten");

                sortingTimer.setStrategy(() -> result.sortedNumbers = sort.sortList(requestMessage.getNumbers()));
                long sortingDuration = sortingTimer.testStrategy();

                ResponseMessage responseMessage = new ResponseMessage(
                        result.sortedNumbers, System.nanoTime(), sortingDuration,
                        receiveTime - requestMessage.getSentTime());
                os.writeObject(responseMessage);
                System.out.println("Client: Response message has been sent");
            }
        } catch (IOException exc) {
            System.out.println("Error with server. Message: " + exc.getMessage());
        } catch (ClassNotFoundException exc) {
            System.out.println("Unknown type of message. Message: " + exc.getMessage());
        }
    }

    private class SortResult {
        List<Integer> sortedNumbers;
    }
}
