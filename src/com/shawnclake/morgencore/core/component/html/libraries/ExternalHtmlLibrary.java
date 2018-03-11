package com.shawnclake.morgencore.core.component.html.libraries;

import com.shawnclake.morgencore.core.component.libraries.ExternalLibrary;

public class ExternalHtmlLibrary extends ExternalLibrary implements HtmlLibrary {

    private HtmlLibraryType htmlLibraryType = HtmlLibraryType.STYLE;

    public ExternalHtmlLibrary(String url) {
        super(url);
    }

    public ExternalHtmlLibrary(String url, HtmlLibraryType htmlLibraryType) {
        super(url);
        this.htmlLibraryType = htmlLibraryType;
    }

    public HtmlLibraryType getHtmlLibraryType() {
        return htmlLibraryType;
    }
}
