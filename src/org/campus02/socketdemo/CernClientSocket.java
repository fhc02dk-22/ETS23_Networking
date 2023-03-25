package org.campus02.socketdemo;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class CernClientSocket {
    public static void main(String[] args) {
        try(// Erzeuge einen neuen Socket und verbinde dich zum Server
            Socket socket = new Socket("info.cern.ch", 80);

            // vom Server lesen
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            // senden Daten an den Server
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            )) {

            // sende daten an den server
            // GET Request an info.cern.ch
            bw.write("GET / HTTP/1.1\r\n");
            bw.write("Host: info.cern.ch\r\n\r\n");
            bw.flush(); //!!!!!!!!!!

            // lesen
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
