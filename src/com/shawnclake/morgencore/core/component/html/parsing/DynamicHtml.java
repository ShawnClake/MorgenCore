package com.shawnclake.morgencore.core.component.html.parsing;

import com.shawnclake.morgencore.core.component.html.Compile;
import com.shawnclake.morgencore.core.component.html.dynamic.VariableInjector;

import java.util.HashMap;

public class DynamicHtml extends Html implements Compile {

    private HashMap<String, String> variables = new HashMap<>();

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

    public HashMap<String, String> getVariables() {
        return variables;
    }

    public DynamicHtml setVariables(HashMap<String, String> variables) {
        this.variables = variables;
        return this;
    }

    public void compileVariables(HashMap<String, String> variables)
    {
        this.html = new VariableInjector(this, variables).compile().getHtmlString();
    }

    @Override
    public Html compile() {
        this.html = new VariableInjector(this, this.variables).compile().getHtmlString();

        return this;
    }

    @Override
    public String getHtmlString() {

        // todo: implement variable injection and other dynamic features



        return this.html;
    }
}
