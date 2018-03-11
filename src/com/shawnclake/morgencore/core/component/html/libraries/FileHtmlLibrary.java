package com.shawnclake.morgencore.core.component.html.libraries;

import com.shawnclake.morgencore.core.component.libraries.FileLibrary;

import java.io.File;

public class FileHtmlLibrary extends FileLibrary implements HtmlLibrary {

    private HtmlLibraryType htmlLibraryType = HtmlLibraryType.STYLE;

    private String path;

    public FileHtmlLibrary(File file) {
        super(file);
    }

    public FileHtmlLibrary(File file, String path) {
        super(file);
        this.path = path;
    }

    public FileHtmlLibrary(File file, HtmlLibraryType htmlLibraryType) {
        super(file);
        this.htmlLibraryType = htmlLibraryType;
    }

    public FileHtmlLibrary(File file, HtmlLibraryType htmlLibraryType, String path) {
        super(file);
        this.path = path;
        this.htmlLibraryType = htmlLibraryType;
    }

    @Override
    public String getPath() {
        if(this.path.length() > 0)
            return path;

        return super.getPath();
    }

    public HtmlLibraryType getHtmlLibraryType() {
        return htmlLibraryType;
    }
}
