package com.parser.pars;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    private static volatile int value = 0;
    public static volatile boolean queue;

    public static void startServer() {
        Thread serverThread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(4242)) {
                System.out.println("TCP-Server is running on 4242...");
                while (true) {
                    Socket client = serverSocket.accept();
                    PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                    out.println(value);
                    queue = true;
                    client.close();
                }
            } catch (Exception e) {
                System.out.println("Server failed: " + e.getMessage());
            }
        });
        serverThread.setDaemon(true);
        serverThread.start();
    }

    public static void setValue(int i) {
        value = i;
        queue = false;
    }
}
