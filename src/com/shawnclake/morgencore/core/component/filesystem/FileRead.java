package com.shawnclake.morgencore.core.component.filesystem;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public String readLine()
    {
        if(file != null) {
            if (file.hasNextLine())
                return file.nextLine();
            return "";
        }
        return  "";
    }

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