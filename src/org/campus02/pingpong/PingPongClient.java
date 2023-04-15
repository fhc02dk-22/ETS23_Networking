package org.campus02.pingpong;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class PingPongClient {

    public static void main(String[] args) {
        try (Socket server = new Socket("localhost", 1111);
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(server.getOutputStream()));
             BufferedReader br = new BufferedReader(
                     new InputStreamReader(server.getInputStream()));
             BufferedReader cli = new BufferedReader(
                     new InputStreamReader(System.in))
        ) {
            // zuerst von der Kommandozeile lesen
            String input;
            while ((input = cli.readLine()) != null) {
                // wenn input = "EXIT" -> beenden
                if (input.equals("EXIT")) {
                    // beenden
                    break;
                }

                // schicke input an den server
                bw.write(input);
                bw.newLine(); //!!!!!!!!!!!
                bw.flush();

                // lese antwort vom server
                System.out.println(br.readLine());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Verbindung beendet");
    }
}
