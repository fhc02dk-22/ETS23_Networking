package org.campus02.URLDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MyFirstURL {

    public static void main(String[] args) {

        try {
            // Erzeugung der URL
            URL myUrl =
                    new URL("https://www.campus02.at:443");

            // Buffered Reader: Lese die Daten von myUrl
            try (BufferedReader br = new BufferedReader(
                         new InputStreamReader(myUrl.openStream()))) {

                String line;
                // lese Zeile für Zeile
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
