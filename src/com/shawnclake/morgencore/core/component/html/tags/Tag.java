package com.shawnclake.morgencore.core.component.html.tags;

import com.shawnclake.morgencore.core.component.html.attributes.Attribute;
import com.shawnclake.morgencore.core.component.html.components.BaseComponent;
import com.shawnclake.morgencore.core.component.html.parsing.Html;

import javax.swing.text.html.HTML;
import java.util.ArrayList;

public class Tag {

    private HTML.Tag tag;
    private ArrayList<Attribute> attributes = new ArrayList<>();

    public Tag(HTML.Tag tag) {
        this.tag = tag;
    }

    public HTML.Tag getTag() {
        return tag;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public RenderedTag getOpeningTag()
    {
        String temp;

        temp = "<" + this.tag.toString() + " ";

        for(Attribute attribute : this.getAttributes())
        {
            temp += attribute.getHtml().getHtmlString() + " ";
        }

        temp = temp.substring(0, temp.length() - 1);

        temp += ">";
        return new RenderedTag(this, new Html(temp));
    }

    public RenderedTag getClosingTag()
    {
        return new RenderedTag(this, new Html("</" + this.tag.toString() + ">"));
    }

    public RenderedTag getFullTag()
    {
        return new RenderedTag(this, this.getOpeningTag().getHtml().appendHtml(this.getClosingTag().getHtml()));
    }

    public RenderedTag getFullTag(BaseComponent contents)
    {

        //System.out.println(contents.getHtml().getHtmlString());

        //System.out.println("starting");
        Html html = this.getOpeningTag().getHtml();
        //System.out.println("1");

        //if(html == null)
        //    System.out.println(this.getOpeningTag().getHtml());

        html.appendHtml(contents.getHtml());
        //System.out.println("2");
        html.appendHtml(this.getClosingTag().getHtml());
        //System.out.println("3");

        return new RenderedTag(this, html);
    }

    /*public RenderedTag getFullTag(Html contents)
    {
        return new RenderedTag(this, this.getOpeningTag().getHtml().appendHtml(contents).appendHtml(this.getClosingTag().getHtml()));
    }

    public RenderedTag getFullTag(RenderedTag contents)
    {
        return new RenderedTag(this, this.getOpeningTag().getHtml().appendHtml(contents.getHtml()).appendHtml(this.getClosingTag().getHtml()));
    }

    public RenderedTag getFullTag(HtmlBuilder contents)
    {
        return new RenderedTag(this, this.getOpeningTag().getHtml().appendHtml(contents.getHtml()).appendHtml(this.getClosingTag().getHtml()));
    }*/






    /*public RenderedTag getRenderedOpeningTag()
    {
        return new RenderedTag(this, this.getOpeningTag());
    }

    public RenderedTag getRenderedClosingTag()
    {
        return new RenderedTag(this, this.getClosingTag());
    }

    public RenderedTag getRenderedFullTag()
    {
        return new RenderedTag(this, this.getFullTag());
    }

    public RenderedTag getRenderedFullTag(String contents)
    {
        return new RenderedTag(this, this.getFullTag(contents));
    }

    public RenderedTag getRenderedFullTag(Html contents)
    {
        return new RenderedTag(this, this.getFullTag(contents));
    }

    public Html getRenderedFullTag(RenderedTag contents)
    {
        return this.getOpeningTag().appendHtml(contents.getHtml()).appendHtml(this.getClosingTag());
    }

    public Html getRenderedFullTag(HtmlBuilder contents)
    {
        return this.getOpeningTag().appendHtml(contents.getHtml()).appendHtml(this.getClosingTag());
    }*/


}
