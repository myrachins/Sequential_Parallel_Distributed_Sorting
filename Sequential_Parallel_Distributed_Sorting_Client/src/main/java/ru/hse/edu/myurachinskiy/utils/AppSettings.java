package ru.hse.edu.myurachinskiy.utils;

public class AppSettings {

    private AppSettings() { }

    private static String serverInetAddress;
    private static int serverPort;

    public synchronized static String getServerInetAddress() {
        return serverInetAddress;
    }

    public synchronized static void setServerInetAddress(String serverInetAddress) {
        AppSettings.serverInetAddress = serverInetAddress;
    }

    public synchronized static int getServerPort() {
        return serverPort;
    }

    public synchronized static void setServerPort(int serverPort) {
        AppSettings.serverPort = serverPort;
    }
}
