package org.campus02.pingpong;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongServer {

    public static void main(String[] args) {
        // server erstellen
        try (ServerSocket serverSocket = new ServerSocket(1111)) {
            // server soll ewig laufen
            while (true) {
                // der server lässt client verbindung zu
                System.out.println("Server wartet auf Client");
                try (Socket client = serverSocket.accept()) {
                    // logik
                    // was wird am server gemacht
                    PingPongHandler pingPongHandler = new PingPongHandler(client);
                    pingPongHandler.process();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
