package com.shawnclake.morgencore.core.component.collections.tree;

import com.shawnclake.morgencore.core.component.collections.Collections;
import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;

import java.util.ArrayList;

abstract public class Node extends AdvancedObject {

    private ArrayList<Node> children = new ArrayList<>();

    public Node(ArrayList<Node> children) {
        this.children = children;
    }

    public Node(int initialSize) {
        Collections.prefillListNull(this.children, initialSize);
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

}
