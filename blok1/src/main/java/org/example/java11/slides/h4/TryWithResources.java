package org.example.java11.slides.h4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class TryWithResources /*extends Object*/ {

    static final String DATA_TXT = "data.txt";

    public void processFileOldStyle() {
        BufferedReader streamOfText = createReader(DATA_TXT);

        try {
            process(streamOfText);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                streamOfText.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void processFileNewStyle() {
        try (BufferedReader streamOfText = createReader(DATA_TXT)) {
            process(streamOfText);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private BufferedReader createReader(String resourceFileName) {
        //         String filename = resourceFileName;
        //         InputStream is = getClass().getResourceAsStream(filename);
        //         InputStreamReader isr = new InputStreamReader(is);
        //         BufferedReader br = new BufferedReader(isr);
        return new BufferedReader(new InputStreamReader(getStreamFrom(resourceFileName)));
    }

    private InputStream getStreamFrom(String resourceFileName) {
        return getClass().getResourceAsStream(resourceFileName);
    }

    private void process(BufferedReader streamOfText) throws IOException {
        StringJoiner total = new StringJoiner(" | ");

        String line;
        while ((line = streamOfText.readLine()) != null) {
            total.add(line);
            // line = streamOfText.readLine();
        }

        System.out.println(total.toString());
    }

    public void readMyResource() {
        try (MyResource mr = new MyResource()) {
            String read = mr.read();
            System.out.println("Read says: " + read);
        }
    }

    public static void main(String[] args) {
        TryWithResources twr = new TryWithResources();

        twr.processFileOldStyle();
        twr.processFileNewStyle();
        twr.readMyResource();
    }
}
