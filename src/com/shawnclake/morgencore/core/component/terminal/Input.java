package com.shawnclake.morgencore.core.component.terminal;

import java.util.Scanner;

/**
 * Input class
 * Helps with scanning for user input from the CLI
 */
public class Input {

    private static Scanner scanner;

    private Input()
    {
        scanner = new Scanner(System.in);
    }

    public static Scanner getScanner()
    {
        return scanner;
    }

    public static String readLine()
    {
        if(scanner == null)
            new Input();
        if(scanner.hasNextLine())
            return scanner.nextLine();

        return "";
    }

}
