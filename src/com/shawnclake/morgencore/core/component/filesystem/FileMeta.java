package com.shawnclake.morgencore.core.component.filesystem;

import com.shawnclake.morgencore.core.component.MetaData;

import java.io.File;

/**
 * FileMeta
 * Allows us to attach meta data to a file
 * THIS DATA DOES NOT PERSIST
 */
public class FileMeta extends MetaData<File> {

    public FileMeta(File file) {
        this.data = file;
    }

    public File getFile()
    {
        return this.getData();
    }


}
