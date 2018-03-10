package com.shawnclake.morgencore.core.component.html.components;

import com.shawnclake.morgencore.core.component.html.parsing.Html;
import com.shawnclake.morgencore.core.component.html.parsing.Htmlable;

abstract public class BaseComponent implements Htmlable {

    protected Html html;

    public Html getHtml() {
        return this.html;
    }

    protected void setHtml(Html html) {
        this.html = html;
    }
}
