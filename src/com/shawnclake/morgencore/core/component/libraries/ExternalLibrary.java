package com.shawnclake.morgencore.core.component.libraries;

import java.util.ArrayList;

public class ExternalLibrary implements Library {

    private String url;

    public ExternalLibrary(String url) {
        this.url = url;
    }

    @Override
    public String getPath() {
        return this.url;
    }

    @Override
    public ArrayList<String> getContents() {
        return new ArrayList<>();
    }
}
