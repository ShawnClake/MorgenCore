package com.shawnclake.morgencore.core.component.html.attributes;

import com.shawnclake.morgencore.core.component.html.parsing.Html;
import com.shawnclake.morgencore.core.component.html.parsing.Htmlable;

import javax.swing.text.html.HTML;

public class Attribute implements Htmlable {

    private HTML.Attribute attribute;
    private String value;

    public Attribute(HTML.Attribute attribute) {
        this.attribute = attribute;
    }
    public Attribute(HTML.Attribute attribute, String value) {
        this.attribute = attribute;
        this.setValue(value);
    }

    public HTML.Attribute getAttribute() {
        return attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Html getHtml() {
        return new Html(this.attribute.toString() + "='" + this.value + "'");
    }
}
