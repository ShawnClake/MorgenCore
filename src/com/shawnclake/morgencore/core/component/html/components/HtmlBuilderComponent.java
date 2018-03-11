package com.shawnclake.morgencore.core.component.html.components;

import com.shawnclake.morgencore.core.component.html.HtmlBuilder;

public class HtmlBuilderComponent extends HtmlComponent {

    public HtmlBuilderComponent(HtmlBuilder htmlBuilder) {
        super(htmlBuilder.getHtml());
    }
}
