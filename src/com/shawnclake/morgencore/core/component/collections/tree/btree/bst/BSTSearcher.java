package com.shawnclake.morgencore.core.component.collections.tree.btree.bst;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;
import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.DynamicPrimitive;
import com.shawnclake.morgencore.core.component.collections.tree.NodeVisitor;
import com.shawnclake.morgencore.core.component.collections.tree.btree.BinaryNode;
import com.shawnclake.morgencore.core.component.collections.tree.btree.BinaryTree;
import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.LazyDynamicPrimitive;

public class BSTSearcher<T extends AdvancedObject> extends NodeVisitor {

    private BinaryTree<T> btree;
    private T target;

    public BSTSearcher(BinaryTree<T> btree) {
        this.btree = btree;
    }

    public DynamicPrimitive visitBinaryNode(BinaryNode<T> node) throws Exception
    {
        //BinaryNode<T> bNode = (BinaryNode)node;

        if(node == null)
            return new LazyDynamicPrimitive<>(false);

        int comparison = node.getValue().__compare__(target);

        if(comparison == 1 && node.getLeft() != null)
            return this.visit(node.getLeft());
        else if (comparison == -1 && node.getRight() != null)
            return this.visit(node.getRight());
        else if(comparison == 0)
            return new LazyDynamicPrimitive<>(true);

        return new LazyDynamicPrimitive<>(false);
    }

    public boolean exists(T target) throws Exception
    {
        this.target = target;
        return this.visit(this.btree.getRoot()).getBoolean();
    }

}
