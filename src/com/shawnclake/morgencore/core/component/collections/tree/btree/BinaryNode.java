package com.shawnclake.morgencore.core.component.collections.tree.btree;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;
import com.shawnclake.morgencore.core.component.collections.tree.Node;

import java.util.ArrayList;

public class BinaryNode<T extends AdvancedObject> extends Node {

    private T value;

    public BinaryNode(T value) {
        super(2);
        this.setLeft(null);
        this.setRight(null);
        this.value = value;
    }

    public BinaryNode(ArrayList<Node> children, T value) {
        super(children);
        this.value = value;
    }

    public BinaryNode(BinaryNode<T> left, BinaryNode<T> right, T value) {
        super(2);
        this.setLeft(left);
        this.setRight(right);
        this.value = value;
    }

    public Node getLeft()
    {
        return this.getChildren().get(0);
    }

    public Node getRight()
    {
        return this.getChildren().get(1);
    }

    public Node setLeft(BinaryNode<T> left)
    {
        return this.getChildren().set(0, left);
    }

    public Node setRight(BinaryNode<T> right)
    {
        return this.getChildren().set(1, right);
    }

    public T getValue() {
        return value;
    }
}
