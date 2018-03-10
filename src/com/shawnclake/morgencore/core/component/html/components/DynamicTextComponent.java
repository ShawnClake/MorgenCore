package com.shawnclake.morgencore.core.component.html.components;

import com.shawnclake.morgencore.core.component.html.parsing.DynamicHtml;

public class DynamicTextComponent extends TextComponent {

    public DynamicTextComponent(String text) {
        super(text);
        this.html = DynamicHtml.htmlToDynamicHtml(this.html);
    }
}
