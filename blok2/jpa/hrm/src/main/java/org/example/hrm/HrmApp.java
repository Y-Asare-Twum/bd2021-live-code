package org.example.hrm;

import org.example.hrm.boundary.HomeScreen;
import org.example.hrm.dao.PersonDao;

import java.util.Scanner;

import static org.example.Em.em;

public class HrmApp {

    public static final PersonDao personDao = PersonDao.instance(em);

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { new HomeScreen().start(); }

    public static String readLine() { return scanner.nextLine(); }

    public static String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

}
