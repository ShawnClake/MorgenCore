package com.shawnclake.morgencore.core.component.html.tags;

import com.shawnclake.morgencore.core.component.html.parsing.DynamicHtml;

import javax.swing.text.html.HTML;

public class DynamicTag extends Tag {

    public DynamicTag(HTML.Tag tag) {
        super(tag);
    }

    @Override
    public RenderedTag getOpeningTag() {
        return new RenderedTag(this, DynamicHtml.htmlToDynamicHtml(super.getOpeningTag().getHtml()));
    }

    @Override
    public RenderedTag getClosingTag() {
        return new RenderedTag(this, DynamicHtml.htmlToDynamicHtml(super.getClosingTag().getHtml()));
    }

    @Override
    public RenderedTag getFullTag() {
        return new RenderedTag(this, DynamicHtml.htmlToDynamicHtml(super.getFullTag().getHtml()));
    }

}
