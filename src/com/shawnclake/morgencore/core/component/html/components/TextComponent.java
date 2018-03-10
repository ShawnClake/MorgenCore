package com.shawnclake.morgencore.core.component.html.components;

import com.shawnclake.morgencore.core.component.html.parsing.Html;

public class TextComponent extends BaseComponent {

    protected String text;

    public TextComponent(String text) {
        this.text = text;
        this.html = new Html(text);
    }

    public String getText() {
        return text;
    }
}
