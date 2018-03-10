package com.shawnclake.morgencore.core.component.html.attributes;

import com.shawnclake.morgencore.core.component.html.parsing.Html;

import javax.swing.text.html.HTML;
import java.util.ArrayList;

public class Class extends Attribute {

    public Class() {
        super(HTML.Attribute.CLASS);
    }

    public Class(String clazz) {
        super(HTML.Attribute.CLASS);
        this.add(clazz);
    }

    private ArrayList<String> classes = new ArrayList<>();

    public ArrayList<String> getClasses() {
        return classes;
    }

    public Class add(String clazz)
    {
        this.classes.add(clazz);
        return this;
    }

    @Override
    public Html getHtml() {
        String html = "class='";
        for(String clazz : this.getClasses())
        {
            html += clazz + " ";
        }

        if(this.getClasses().size() > 0)
            html = html.substring(0, html.length() - 1);

        html += "'";

        return new Html(html);
    }
}
