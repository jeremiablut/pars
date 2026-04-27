package com.parser.pars;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Reader {
    public static volatile String answer = "failed";
    public static void main(String[] args) {
        while (true) {
            try {
                Socket socket = new Socket("localhost", 4242);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                answer = in.readLine();
                socket.close();
                Thread.sleep(1);
            } catch (Exception e) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {}
            }
        }
    }
}
