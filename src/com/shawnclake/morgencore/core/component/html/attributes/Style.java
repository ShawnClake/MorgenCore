package com.shawnclake.morgencore.core.component.html.attributes;

import com.shawnclake.morgencore.core.component.html.parsing.Html;

import javax.swing.text.html.HTML;
import java.util.HashMap;
import java.util.Map;

public class Style extends Attribute {

    public Style() {
        super(HTML.Attribute.STYLE);
    }

    public Style(String type, String value) {
        super(HTML.Attribute.STYLE);
        this.add(type,value);
    }

    private HashMap<String, String> styles = new HashMap<>();

    public HashMap<String, String> getStyles() {
        return styles;
    }

    public Style add(String type, String value)
    {
        this.styles.put(type, value);
        return this;
    }

    @Override
    public Html getHtml() {

        String html = "style='";
        for(Map.Entry<String, String> entry : this.styles.entrySet())
        {
            html += entry.getKey() + ":" + entry.getValue() + ";";
        }

        html += "'";

        return new Html(html);

    }
}
