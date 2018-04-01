package com.shawnclake.morgencore.core.component.collections.tree.btree.bst;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;
import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.DynamicPrimitive;
import com.shawnclake.morgencore.core.component.collections.tree.NodeVisitor;
import com.shawnclake.morgencore.core.component.collections.tree.btree.BinaryNode;
import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.LazyDynamicPrimitive;

public class BSTBuilder<T extends AdvancedObject> extends NodeVisitor {

    private BinarySearchTree<T> btree;
    private T data;

    public BSTBuilder(BinarySearchTree<T> btree) {
        this.btree = btree;
    }

    public DynamicPrimitive visitBinaryNode(BinaryNode<T> node) throws Exception
    {
        //BinaryNode<T> bNode = (BinaryNode<T>)node;

        int comparison = node.getValue().__compare__(data);

        if(comparison == 1)
        {
            BinaryNode<T> left = (BinaryNode<T>)node.getLeft();

            if(left == null)
            {
                node.setLeft(new BinaryNode<>(null, null, data));
                return new LazyDynamicPrimitive<>(true);
            }

            this.visit(left);
        }
        else if (comparison == -1)
        {
            BinaryNode<T> right = (BinaryNode<T>)node.getRight();

            if(right == null)
            {
                node.setRight(new BinaryNode<>(null, null, data));
                return new LazyDynamicPrimitive<>(true);
            }

            this.visit(right);
        }
        else if(comparison == 0)
            return new LazyDynamicPrimitive<>(true);

        return new LazyDynamicPrimitive<>(false);
    }

    public boolean add(T data) throws Exception
    {
        this.data = data;
        return this.visit(this.btree.getRoot()).getBoolean();
    }
}
