package com.shawnclake.morgencore.core.component.html.components;

import com.shawnclake.morgencore.core.component.html.tags.RenderedTag;

public class TagComponent extends BaseComponent {

    private RenderedTag tag;

    public TagComponent(RenderedTag tag) {
        this.tag = tag;
        this.html = this.tag.getHtml();
    }

    public RenderedTag getTag() {
        return tag;
    }
}
