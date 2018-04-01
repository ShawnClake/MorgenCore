package com.shawnclake.morgencore.core.component.collections.tree;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;

abstract public class Tree extends AdvancedObject {

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    abstract public int height(Node root);

}
