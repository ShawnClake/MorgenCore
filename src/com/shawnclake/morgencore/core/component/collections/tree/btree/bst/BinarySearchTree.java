package com.shawnclake.morgencore.core.component.collections.tree.btree.bst;

import com.shawnclake.morgencore.core.component.collections.tree.btree.BinaryNode;
import com.shawnclake.morgencore.core.component.collections.tree.btree.BinaryTree;
import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;

public class BinarySearchTree<T extends AdvancedObject> extends BinaryTree<T> {

    private BSTBuilder<T> bstBuilder;
    private BSTSearcher<T> bstSearcher;

    public BinarySearchTree(BinaryNode<T> root) {
        super(root);
        bstBuilder = new BSTBuilder<>(this);
        bstSearcher = new BSTSearcher<>(this);
    }

    public boolean add(T data)
    {
        try {
            return this.bstBuilder.add(data);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean exists(T data)
    {
        try {
            return this.bstSearcher.exists(data);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
