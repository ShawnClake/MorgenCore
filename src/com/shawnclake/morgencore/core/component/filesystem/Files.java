package com.shawnclake.morgencore.core.component.filesystem;

import com.shawnclake.morgencore.core.component.Collections;

import java.io.File;
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

}
