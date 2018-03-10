package com.shawnclake.morgencore.core.component.html.tags;

import com.shawnclake.morgencore.core.component.html.parsing.Html;
import com.shawnclake.morgencore.core.component.html.parsing.Htmlable;

public class RenderedTag implements Htmlable {

    private Tag tag;
    private Html html;

    public RenderedTag(Tag tag, Html renderedTagHtml) {
        this.tag = tag;
        this.html = renderedTagHtml;
    }

    @Override
    public Html getHtml() {
        return html;
    }

    public Tag getTag() {
        return tag;
    }

    public static RenderedTag render(Tag tag, Html renderedTagHtml)
    {
        return new RenderedTag(tag, renderedTagHtml);
    }
}
