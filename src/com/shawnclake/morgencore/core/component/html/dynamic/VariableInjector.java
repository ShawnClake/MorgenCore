package com.shawnclake.morgencore.core.component.html.dynamic;

import com.shawnclake.morgencore.core.component.RegexResult;
import com.shawnclake.morgencore.core.component.Strings;
import com.shawnclake.morgencore.core.component.html.Compile;
import com.shawnclake.morgencore.core.component.html.parsing.Html;

import java.util.ArrayList;
import java.util.HashMap;

public class VariableInjector implements Compile {

    public static final String VARIABLE_REGEX = "\\{\\{[A-z0-9. ]{3,}\\}\\}";


    private Html html;
    private HashMap<String, String> variables;

    public VariableInjector(Html html, HashMap<String, String> variables) {
        this.html = html;
        this.variables = variables;
    }

    public Html compile()
    {
        String htmlString = this.html.getHtmlString();

        ArrayList<RegexResult> regexResults = Strings.getMatches(htmlString, VARIABLE_REGEX);

        for(RegexResult regexResult : regexResults)
        {
            String variableName = regexResult.getMatch().substring(2, regexResult.getMatch().length() - 2).trim();

            if(this.variables.containsKey(variableName))
            {
                htmlString = htmlString.replace(regexResult.getMatch(), this.variables.get(variableName));
            } else {
                System.out.println("Variable was not found for " + regexResult.getMatch());
            }
        }

        return new Html(htmlString);
    }


}
