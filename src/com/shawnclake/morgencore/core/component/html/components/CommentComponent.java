package com.shawnclake.morgencore.core.component.html.components;

import com.shawnclake.morgencore.core.component.html.parsing.Html;

public class CommentComponent extends BaseComponent {

    protected String comment;

    public CommentComponent(String comment) {
        this.comment = comment;
        this.html = new Html("<!-- ").appendHtml(comment).appendHtml(" -->");
    }

    public String getComment() {
        return comment;
    }

}
