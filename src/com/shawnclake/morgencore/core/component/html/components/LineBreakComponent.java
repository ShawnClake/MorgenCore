package com.shawnclake.morgencore.core.component.html.components;

import com.shawnclake.morgencore.core.component.html.tags.TagBuilder;

import javax.swing.text.html.HTML;

public class LineBreakComponent extends HtmlComponent {
    public LineBreakComponent() {
        super(new TagBuilder(HTML.Tag.BR).getTag().getOpeningTag().getHtml());
    }
}
