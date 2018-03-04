package com.shawnclake.morgencore.core.component.filesystem;

import com.shawnclake.morgencore.core.component.Collections;
import com.shawnclake.morgencore.core.component.messages.ListMessage;
import com.shawnclake.morgencore.core.component.messages.Message;
import com.shawnclake.morgencore.core.component.messages.StringMessage;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Files {

    private void listFilesRecursivelyHelper(String directoryName, ArrayList<File> files) {
        File directory = new File(directoryName);

        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                listFilesRecursivelyHelper(file.getAbsolutePath(), files);
            }
        }
    }

    public ArrayList<File> listFilesRecursively(String directoryName) {

        ArrayList<File> files = new ArrayList<>();

        this.listFilesRecursivelyHelper(directoryName, files);

        return files;
    }

    public ArrayList<File> listFiles(String directoryName) {
        File directory = new File(directoryName);
        if(directory.exists() && directory.isDirectory()) {
            return new ArrayList<>(Collections.toArrayList(directory.listFiles()));
        }
        return new ArrayList<>();
    }

    public ArrayList<String> listFileNames(String directoryName) {
        File directory = new File(directoryName);
        if(directory.exists() && directory.isDirectory()) {
            return new ArrayList<>(Collections.toArrayList(directory.list()));
        }
        return new ArrayList<>();
    }

    public ArrayList<File> listFiles(File directory) {
        if(directory.exists() && directory.isDirectory()) {
            return new ArrayList<>(Collections.toArrayList(directory.listFiles()));
        }
        return new ArrayList<>();
    }

    public ArrayList<String> listFileNames(File directory) {
        if(directory.exists() && directory.isDirectory()) {
            return new ArrayList<>(Collections.toArrayList(directory.list()));
        }
        return new ArrayList<>();
    }

    public boolean isExist(String path)
    {
        File file = new File(path);
        return file.exists();
    }

    public boolean isDirectory(String path)
    {
        File directory = new File(path);
        if(directory.exists() && directory.isDirectory()) {
            return true;
        }
        return false;
    }

    public boolean isFile(String path)
    {
        File file = new File(path);
        if(file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }

    public String getFileExtension(File file, boolean includeDot) {
        String name = file.getName();
        try {
            int length = name.lastIndexOf(".");
            if(!includeDot)
                length++;
            return name.substring(length);
        } catch (Exception e) {
            return "";
        }
    }

    public boolean createDirectory(String path)
    {
        try {
            java.nio.file.Files.createDirectories(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean createFile(String path)
    {
        try {
            java.nio.file.Files.createFile(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean createFile(String path, String content)
    {

        try {
            java.nio.file.Files.write(Paths.get(path), Collections.toArrayList(content), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean createFile(String path, String content, Charset encoding)
    {
        try {
            java.nio.file.Files.write(Paths.get(path), Collections.toArrayList(content), encoding);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean createFile(String path, ArrayList<String> content)
    {
        try {
            java.nio.file.Files.write(Paths.get(path), content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean createFile(String path, ArrayList<String> content, Charset encoding)
    {
        try {
            java.nio.file.Files.write(Paths.get(path), content, encoding);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean createFile(String path, StringMessage content)
    {
        return this.createFile(path, content.getMessage());
    }

    public boolean createFile(String path, StringMessage content, Charset encoding)
    {
        return this.createFile(path, content.getMessage(), encoding);
    }

    public boolean createFile(String path, ListMessage content)
    {
        return this.createFile(path, content.getMessage());
    }

    public boolean createFile(String path, ListMessage content, Charset encoding)
    {
        return this.createFile(path, content.getMessage(), encoding);
    }

    /**
     * Taken from ChrisB's answer on
     * https://stackoverflow.com/questions/13195797/delete-all-files-in-directory-but-not-directory-one-liner-solution
     * @param dir
     */
    private void purgeDirectoryHelper(File dir) {
        for (File file: dir.listFiles()) {
            if (file.isDirectory()) purgeDirectoryHelper(file);
            file.delete();
        }
    }

    public void purgeDirectory(String path) {
        File file = new File(path);
        this.purgeDirectoryHelper(file);
    }

}
