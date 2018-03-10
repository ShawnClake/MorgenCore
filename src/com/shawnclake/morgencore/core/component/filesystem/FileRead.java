package com.shawnclake.morgencore.core.component.filesystem;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FileRead
 * Helps with reading of files
 */
public class FileRead {

    private String path;
    private Scanner file;

    public FileRead(String filePath)
    {
        path = filePath;
        openFileIn();
    }

    public boolean openFile(String filePath)
    {
        path = filePath;
        return openFileIn();
    }

    /**
     * Reads the next line and returns it as a string
     * @return
     */
    public String readLine()
    {
        if(file != null) {
            if (file.hasNextLine())
                return file.nextLine();
            return "";
        }
        return  "";
    }

    /**
     * Returns the entire file as an array list where each entry in the array list is a line
     * from the file
     * @return
     * @throws IOException
     */
    public List<String> getEntireFile() throws IOException
    {
        File f = new File(path);
        if(f.exists() && !f.isDirectory())
        {
            Path filepath = FileSystems.getDefault().getPath(path);
            return java.nio.file.Files.readAllLines(filepath, Charset.defaultCharset());
        }

        return new ArrayList<>();
    }

    /**
     * Gets the rest of the file that needs to be read and returns it as an array list where each entry
     * is a line from the file
     * @return
     */
    public List<String> getRemainderOfFile()
    {
        if(file != null) {
            List<String> lines = new ArrayList<>();

            while (file.hasNextLine()) {
                String line = file.nextLine();
                lines.add(line);
            }

            return lines;
        }
        return new ArrayList<>();
    }

    /**
     * Force the file to close
     */
    public void forceCloseFile()
    {
        file.close();
    }

    private boolean openFileIn()
    {
        File f = new File(path);
        if(f.exists() && !f.isDirectory()) {
            try {

                file = new Scanner(Paths.get(path));

            } catch (IOException e) {

                e.printStackTrace();

                return false;

            }
            return true;
        }

        return false;

    }


}
