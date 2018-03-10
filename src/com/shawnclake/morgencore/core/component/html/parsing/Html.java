package com.shawnclake.morgencore.core.component.html.parsing;

public class Html {

    protected String html;

    public Html(String html) {
        this.html = html;
    }

    public Html(Html html) {
        this.html = html.getHtmlString();
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getHtmlString() {
        return html;
    }

    public Html appendHtml(String html)
    {
        this.html += html;
        return this;
    }

    public Html appendHtml(Html html)
    {
        this.html += html.getHtmlString();
        return this;
    }

}
