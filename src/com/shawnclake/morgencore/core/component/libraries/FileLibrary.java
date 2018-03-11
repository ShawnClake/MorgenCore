package com.shawnclake.morgencore.core.component.libraries;

import com.shawnclake.morgencore.core.component.filesystem.FileRead;

import java.io.File;
import java.util.ArrayList;

public class FileLibrary implements Library {

    private File file;

    public FileLibrary(File file) {
        this.file = file;
    }

    public ArrayList<String> getContents()
    {
        return new ArrayList<>(new FileRead(this.file.getAbsolutePath()).getEntireFile());
    }

    public String getPath()
    {
        return this.file.getAbsolutePath();
    }

    public File getFile() {
        return file;
    }
}
