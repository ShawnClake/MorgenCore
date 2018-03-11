package com.shawnclake.morgencore.core.component.html.components;

import com.shawnclake.morgencore.core.component.html.libraries.HtmlLibrary;
import com.shawnclake.morgencore.core.component.html.attributes.Attribute;
import com.shawnclake.morgencore.core.component.html.parsing.Html;
import com.shawnclake.morgencore.core.component.html.tags.TagBuilder;

import javax.swing.text.html.HTML;

public class StyleImportComponent extends HtmlComponent {

    public StyleImportComponent(HtmlLibrary library) {
        super(new Html(""));

        this.getHtml().appendHtml(TagBuilder.build(HTML.Tag.LINK)
                .addAttribute(new Attribute(HTML.Attribute.REL, "stylesheet"))
                .addAttribute(new Attribute(HTML.Attribute.HREF, library.getPath()))
                .getTag().getOpeningTag().getHtml());

    }
}
