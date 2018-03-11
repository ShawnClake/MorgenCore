package com.shawnclake.morgencore.core.component.html;

import com.shawnclake.morgencore.core.component.html.components.*;
import com.shawnclake.morgencore.core.component.html.libraries.HtmlLibrary;
import com.shawnclake.morgencore.core.component.html.libraries.HtmlLibraryType;
import com.shawnclake.morgencore.core.component.html.parsing.Html;
import com.shawnclake.morgencore.core.component.html.parsing.Htmlable;
import com.shawnclake.morgencore.core.component.html.tags.TagBuilder;

import javax.swing.text.html.HTML;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HtmlPageBuilder implements Htmlable {

    private HashMap<HtmlLibrary, Boolean> libraries = new HashMap<>();

    private HtmlBuilder head = new HtmlBuilder(new CommentComponent(new Date().toString()));
    private HtmlBuilder body = new HtmlBuilder(new CommentComponent(new Date().toString()));

    public static HtmlPageBuilder build(String title)
    {
        return new HtmlPageBuilder(title);
    }

    public HtmlPageBuilder(String title) {
        this.head.append(new TagComponent(TagBuilder.build(HTML.Tag.TITLE).getFullTag(new TextComponent(title))));
    }

    public HtmlPageBuilder addLibrary(HtmlLibrary library, boolean inHead)
    {
        this.libraries.put(library, inHead);
        return this;
    }

    public HtmlPageBuilder addLibrary(HtmlLibrary library)
    {
        this.libraries.put(library, false);
        return this;
    }

    public HashMap<HtmlLibrary, Boolean> getLibraries() {
        return libraries;
    }

    public HtmlBuilder getHead() {
        return head;
    }

    public HtmlBuilder getBody() {
        return body;
    }

    public HtmlPageBuilder appendHead(BaseComponent component)
    {
        this.head.append(component);
        return this;
    }

    public HtmlPageBuilder appendBody(BaseComponent component)
    {
        this.body.append(component);
        return this;
    }

    public HtmlBuilder getHtmlBuilder()
    {
        //
        GroupComponent headGroup = new GroupComponent(new HtmlBuilderComponent(this.head));
        GroupComponent bodyGroup = new GroupComponent(new HtmlBuilderComponent(this.body));

        for(Map.Entry<HtmlLibrary, Boolean> entry : this.libraries.entrySet())
        {
            HtmlLibrary library = entry.getKey();
            boolean inHead = entry.getValue();
            BaseComponent component = new CommentComponent("Foreign Library Type not Recognized");

            if(library.getHtmlLibraryType() == HtmlLibraryType.STYLE)
            {
                component = new StyleImportComponent(library);
            }

            if(library.getHtmlLibraryType() == HtmlLibraryType.SCRIPT)
            {
                component = new ScriptImportComponent(library);
            }

            if(inHead)
                headGroup.append(component);
            else
                bodyGroup.append(component);
        }

        TagComponent headTag = new TagComponent(TagBuilder.build(HTML.Tag.HEAD).getFullTag(headGroup));
        TagComponent bodyTag = new TagComponent(TagBuilder.build(HTML.Tag.BODY).getFullTag(bodyGroup));

        HtmlBuilder htmlBuilder = HtmlBuilder.build(new TagComponent(TagBuilder.build(HTML.Tag.HTML).getFullTag(
                new GroupComponent(headTag).append(bodyTag)
        )));

        return htmlBuilder;
    }

    public Html getHtml()
    {
        return this.getHtmlBuilder().getHtml();
    }


}
