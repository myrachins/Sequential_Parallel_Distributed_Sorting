package ru.hse.edu.myurachinskiy.utils;

public class AppSettings {

    private AppSettings() { }

    public static final String CLIENT_INET_ADDRESS = "localhost";
    public static final int CLIENT_PORT = 4000;

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
