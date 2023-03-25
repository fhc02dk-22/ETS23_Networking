package org.campus02.socketdemo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FirstServerSocket {

    public static void main(String[] args) {
        // Erzeuge einen Server
        System.out.println("Server wird erstellt");
        try (ServerSocket serverSocket = new ServerSocket(1111)) {
            while (true) {

                System.out.println("warte auf Client");
                try (Socket client = serverSocket.accept();
                        // Kanal zum Schreiben geöffnet
                     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {

                    System.out.println("client hat sich verbunden");

                    bw.write("Hallo Client");
                    bw.flush(); // !!!!!
                    System.out.println("Daten an Client gesendet");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
