package org.campus02.URLDemo;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MyFirstURL {

    public static void main(String[] args) {

        try {
            // Erzeugung der URL
            URL myUrl =
                    new URL("https://www.campus02.at:443");

            // Buffered Reader: Lese die Daten von myUrl
            // Buffered Writer: zum Schreiben
            try (BufferedReader br = new BufferedReader(
                         new InputStreamReader(myUrl.openStream()));
                 BufferedWriter bw =
                         new BufferedWriter(
                                 new FileWriter("src/org/campus02/URLDemo/htmlFiles/campus02.html"))
            ) {
                String line;
                // lese Zeile für Zeile
                while ((line = br.readLine()) != null) {
                    System.out.println(line);

                    // schreibe die Daten in das File
                    bw.write(line);
                    //bw.flush();    hier könnten wir zwischenspeichern
                }
                bw.flush(); // !!!! flush nicht vergessen
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
