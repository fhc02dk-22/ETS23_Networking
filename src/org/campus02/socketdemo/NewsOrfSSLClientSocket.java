package org.campus02.socketdemo;

import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class NewsOrfSSLClientSocket {

    public static void main(String[] args) {
        // SSL Socket mithilfe der Factory Klasse erzeugen
        // mittels https verbinden
        // Kanal zum Schreiben öffnen -> outputstream
        // Kanal zum Lesen öffnen -> inputstream
        try (Socket socket = SSLSocketFactory
                .getDefault()
                .createSocket("news.orf.at", 443);
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader br = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))
        ) {
            // schicke get request
            bw.write("GET / HTTP/1.1\r\nHost: news.orf.at\r\n\r\n");
            bw.flush(); // !!!!!!!

            // lese response vom server
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
