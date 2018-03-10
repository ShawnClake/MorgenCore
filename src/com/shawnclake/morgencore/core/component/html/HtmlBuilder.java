package com.shawnclake.morgencore.core.component.html;

import com.shawnclake.morgencore.core.component.html.components.BaseComponent;
import com.shawnclake.morgencore.core.component.html.components.HtmlComponent;
import com.shawnclake.morgencore.core.component.html.parsing.Html;

/**
 * HtmlBuilder
 * Forms HTML based on supplied components
 */
public class HtmlBuilder {

    private Html html = new Html("");

    /*public HtmlBuilder(String html) {
        this.append(html);
    }*/

    public HtmlBuilder(BaseComponent baseComponent) {
        this.append(baseComponent);
    }

    public HtmlBuilder append(BaseComponent baseComponent)
    {
        this.html.appendHtml(baseComponent.getHtml());
        return this;
    }

    /*public HtmlBuilder append(String html)
    {
        this.html += html;
        return this;
    }*/

    public HtmlComponent getAsComponent()
    {
        return new HtmlComponent(this.html);
    }

    public Html getHtml()
    {
        return html;
    }

    public static HtmlBuilder build(BaseComponent baseComponent)
    {
        return new HtmlBuilder(baseComponent);
    }

}
