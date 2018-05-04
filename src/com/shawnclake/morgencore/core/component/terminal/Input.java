package com.shawnclake.morgencore.core.component.terminal;

import com.shawnclake.morgencore.core.component.messages.Message;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

    public static Message readLine(TerminalInteractable terminalInteractable)
    {
        if(scanner == null)
            new Input();
        if(scanner.hasNextLine())
            return terminalInteractable.input(scanner.nextLine());

        //Output.pln("should not reach");

        return terminalInteractable.input("");
    }

    public static void stopSimulating()
    {
        scanner = new Scanner(System.in);
    }

    public static void simulateInput(String input)
    {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        scanner = new Scanner(in);
    }

}
