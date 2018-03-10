package com.shawnclake.morgencore.core.component.html.tags;

import com.shawnclake.morgencore.core.component.html.attributes.Attribute;

import javax.swing.text.html.HTML;

public class TagBuilder {

    private Tag tag;

    public TagBuilder(HTML.Tag tag) {
        this.tag = new Tag(tag);
    }

    public TagBuilder(HTML.Tag tag, boolean isDynamic) {
        if(isDynamic)
            this.tag = new DynamicTag(tag);
        else
            this.tag = new Tag(tag);
    }

    public boolean isDynamic()
    {
        return this.tag instanceof DynamicTag;
    }

    public TagBuilder addAttribute(Attribute attribute)
    {
        this.tag.getAttributes().add(attribute);
        return this;
    }

    public Tag getTag()
    {
        return this.tag;
    }

    public static TagBuilder build(HTML.Tag tag)
    {
        return new TagBuilder(tag);
    }

    public static TagBuilder build(HTML.Tag tag, boolean isDynamic)
    {
        return new TagBuilder(tag, isDynamic);
    }

}
