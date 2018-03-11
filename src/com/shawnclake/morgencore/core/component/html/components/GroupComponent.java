package com.shawnclake.morgencore.core.component.html.components;

import java.util.ArrayList;

public class GroupComponent extends HtmlComponent {

    private ArrayList<BaseComponent> components = new ArrayList<>();

    public GroupComponent(BaseComponent component) {
        super(component.getHtml());
        this.components.add(component);
    }

    public GroupComponent append(BaseComponent component)
    {
        this.components.add(component);
        this.html.appendHtml(component.getHtml());
        return this;
    }

    public ArrayList<BaseComponent> getComponents() {
        return components;
    }
}
