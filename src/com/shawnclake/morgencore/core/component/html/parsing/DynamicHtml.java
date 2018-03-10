package com.shawnclake.morgencore.core.component.html.parsing;

public class DynamicHtml extends Html {

    public DynamicHtml(Html html) {
        super(html);
    }

    public DynamicHtml(String html) {
        super(html);
    }

    public static DynamicHtml htmlToDynamicHtml(Html html)
    {
        return new DynamicHtml(html);
    }

    @Override
    public String getHtmlString() {

        // todo: implement variable injection and other dynamic features
        return this.html;
    }
}
