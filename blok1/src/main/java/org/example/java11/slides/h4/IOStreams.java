package org.example.java11.slides.h4;

import java.io.*;

public class IOStreams {

    public void demo() throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader("xanadu.txt"));
             PrintWriter out = new PrintWriter(new FileWriter("outagain.txt"))) {
            String s = in.readLine();
            out.write(s);
        }
    }

}
