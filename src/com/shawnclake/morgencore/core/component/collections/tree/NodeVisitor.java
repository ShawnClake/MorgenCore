package com.shawnclake.morgencore.core.component.collections.tree;

import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.DynamicPrimitive;
import com.shawnclake.morgencore.core.component.patterns.Visitor;

import java.lang.reflect.Method;

abstract public class NodeVisitor implements Visitor {

    // TODO: use reflection on the node parameter passed to dynamically call a visit function
    // TODO: Probably in the form "visitTheNameOfTheNodeClass(TheNodeType param)"
    protected DynamicPrimitive visit(Node node) throws Exception
    {
        if(node == null)
            throw new Exception("Cannot visit a null node");

        String methodName = "visit";
        methodName += node.getClass().getSimpleName();

        DynamicPrimitive result;

        //Output.pln(com.shawnclake.morgencore.core.component.collections.Collections.toArrayList(this.getClass().getMethods()).toString());

        try {
            Method method = this.getClass().getMethod(methodName, node.getClass());
            try {
                Object returned = method.invoke(this, node);
                if(returned instanceof DynamicPrimitive)
                    result = (DynamicPrimitive)returned;
                else
                    throw new Exception("Result from visitor method was not in expected form");
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                throw new Exception("Fatal error while trying to access visitor method");
            } /*catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }*/
        } catch (NoSuchMethodException e1) {
            throw new Exception("Visitor method was not found: " + methodName);
        }

        return result;
    }
}
