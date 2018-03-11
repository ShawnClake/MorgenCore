package com.shawnclake.morgencore.core.component.html.components;

import com.shawnclake.morgencore.core.component.libraries.Library;
import com.shawnclake.morgencore.core.component.html.attributes.Attribute;
import com.shawnclake.morgencore.core.component.html.parsing.Html;
import com.shawnclake.morgencore.core.component.html.tags.TagBuilder;

import javax.swing.text.html.HTML;

public class ScriptImportComponent extends HtmlComponent {

    public ScriptImportComponent(Library library) {
        super(new Html(""));

        this.getHtml().appendHtml(TagBuilder.build(HTML.Tag.SCRIPT)
                .addAttribute(new Attribute(HTML.Attribute.SRC, library.getPath()))
                .getTag().getFullTag().getHtml());
    }
}
