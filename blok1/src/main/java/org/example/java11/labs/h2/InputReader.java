package org.example.java11.labs.h2;

public class InputReader {

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        //
        // System.out.println("Enter username");
        // String userName = in.nextLine(); // eerste input
        // System.out.println("Username is: " + userName);
        //
        // System.out.println("Enter age");
        // String age = in.nextLine();   // tweede input
        // System.out.println("User age is: " + age);
        //
        // int plusTwo = abs(-2);
        String file = "tekst.txt";
        // String path = "Bram zegt \\ : \"wat gaat hier mis?\""; // \ is een escape character
        String path = "C:\\temp\\";

        String formattedText =
                String.format("File %-15s not found at %s, length %10d", file, path, path.length());

        System.out.println(formattedText);
    }

}
