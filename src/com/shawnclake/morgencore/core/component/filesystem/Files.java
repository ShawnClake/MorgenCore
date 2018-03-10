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

/**
 * Files
 * Helps us with observing directories of files or data about a file
 * Does not read/write files
 */
public class Files {

    /**
     * List all files within a dir recursively
     * This is a recursion helper
     * @param directoryName
     * @param files
     */
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

    /**
     * List all files within a dir recursively
     * @param directoryName
     * @return
     */
    public ArrayList<File> listFilesRecursively(String directoryName) {

        ArrayList<File> files = new ArrayList<>();

        this.listFilesRecursivelyHelper(directoryName, files);

        return files;
    }

    /**
     * Returns only the top level files including directories within a directory
     * @param directoryName
     * @return
     */
    public ArrayList<File> listFiles(String directoryName) {
        File directory = new File(directoryName);
        if(directory.exists() && directory.isDirectory()) {
            return new ArrayList<>(Collections.toArrayList(directory.listFiles()));
        }
        return new ArrayList<>();
    }

    /**
     * Return only the top level file/directory names within a directory
     * @param directoryName
     * @return
     */
    public ArrayList<String> listFileNames(String directoryName) {
        File directory = new File(directoryName);
        if(directory.exists() && directory.isDirectory()) {
            return new ArrayList<>(Collections.toArrayList(directory.list()));
        }
        return new ArrayList<>();
    }

    /**
     * Returns only the top level files including directories within a directory
     * @param directory
     * @return
     */
    public ArrayList<File> listFiles(File directory) {
        if(directory.exists() && directory.isDirectory()) {
            return new ArrayList<>(Collections.toArrayList(directory.listFiles()));
        }
        return new ArrayList<>();
    }

    /**
     * Return only the top level file/directory names within a directory
     * @param directory
     * @return
     */
    public ArrayList<String> listFileNames(File directory) {
        if(directory.exists() && directory.isDirectory()) {
            return new ArrayList<>(Collections.toArrayList(directory.list()));
        }
        return new ArrayList<>();
    }

    /**
     * Determine whether a file exists at the provided path
     * @param path
     * @return
     */
    public boolean isExist(String path)
    {
        File file = new File(path);
        return file.exists();
    }

    /**
     * Returns whether the supplied path ends in a dir
     * @param path
     * @return
     */
    public boolean isDirectory(String path)
    {
        File directory = new File(path);
        if(directory.exists() && directory.isDirectory()) {
            return true;
        }
        return false;
    }

    /**
     * Determines whether the supplied path ends in a file
     * @param path
     * @return
     */
    public boolean isFile(String path)
    {
        File file = new File(path);
        if(file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }

    /**
     * Gets the file extensions for a supplied file
     * When includeDot is true, the returned extension will be in the form ".exe"
     * When it is instead false, it will return in the form "exe"
     * @param file
     * @param includeDot
     * @return
     */
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

    /**
     * Creates a directory at the given path
     * @param path
     * @return
     */
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

    /**
     * Creates an empty file at the given path
     * @param path
     * @return
     */
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

    /**
     * Creates a file with the supplied content at the given path
     * Uses UTF_8
     * @param path
     * @param content
     * @return
     */
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

    /**
     * Creates a file with the supplied content at the given path
     * Uses supplied encoding
     * @param path
     * @param content
     * @param encoding
     * @return
     */
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

    /**
     * Creates a file with the supplied content at the given path
     * Each entry in the array list will be a new line in the file
     * Uses UTF_8
     * @param path
     * @param content
     * @return
     */
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

    /**
     * Creates a file with the supplied content at the given path
     * Each entry in the array list will be a new line in the file
     * Uses supplied encoding
     * @param path
     * @param content
     * @param encoding
     * @return
     */
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

    /**
     * Creates a file with the supplied content at the given path
     * Will use UTF_8
     * @param path
     * @param content
     * @return
     */
    public boolean createFile(String path, StringMessage content)
    {
        return this.createFile(path, content.getMessage());
    }

    /**
     * Creates a file with the supplied content at the given path
     * Uses supplied encoding
     * @param path
     * @param content
     * @param encoding
     * @return
     */
    public boolean createFile(String path, StringMessage content, Charset encoding)
    {
        return this.createFile(path, content.getMessage(), encoding);
    }

    /**
     * Creates a file with the supplied content at the given path
     * Will use UTF_8
     * @param path
     * @param content
     * @return
     */
    public boolean createFile(String path, ListMessage content)
    {
        return this.createFile(path, content.getMessage());
    }

    /**
     * Creates a file with the supplied content at the given path
     * Uses supplied encoding
     * @param path
     * @param content
     * @param encoding
     * @return
     */
    public boolean createFile(String path, ListMessage content, Charset encoding)
    {
        return this.createFile(path, content.getMessage(), encoding);
    }

    /**
     * Removes any and all files/dirs at a given path not including itself. Empties the given path in other words
     * Recursive helper
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

    /**
     * Removes any and all files/dirs at a given path not including itself. Empties the given path in other words
     * @param path
     */
    public void purgeDirectory(String path) {
        File file = new File(path);
        this.purgeDirectoryHelper(file);
    }

}
