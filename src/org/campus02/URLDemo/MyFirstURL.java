package org.campus02.URLDemo;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MyFirstURL {

    public static void main(String[] args) {

        try {
            // Erzeugung der URL
            URL myUrl =
                    new URL("https://www.campus02.at");

            // Buffered Reader: Lese die Daten von myUrl
            // Buffered Writer: zum Schreiben
            try (BufferedReader br = new BufferedReader(
                         new InputStreamReader(myUrl.openStream()));
                 BufferedWriter bw =
                         new BufferedWriter(
                                 new FileWriter("src/org/campus02/URLDemo/htmlFiles/campus02.html"));
                 PrintWriter pw =
                         new PrintWriter(
                                 new FileWriter("src/org/campus02/URLDemo/htmlFiles/campus02_pw.html"))
            ) {
                String line;
                // lese Zeile für Zeile
                while ((line = br.readLine()) != null) {
                    //System.out.println(line);

                    // schreibe die Daten in das File
                    bw.write(line);
                    bw.newLine();
                    //bw.flush();    hier könnten wir zwischenspeichern

                    pw.println(line);
                }
                bw.flush(); // !!!! flush nicht vergessen
                pw.flush();
            }

            System.out.println();
            System.out.println("myUrl.getProtocol() = " + myUrl.getProtocol());
            System.out.println("myUrl.getHost() = " + myUrl.getHost());
            System.out.println("myUrl.getPort() = " + myUrl.getPort());
            System.out.println("myUrl.getDefaultPort() = " + myUrl.getDefaultPort());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
