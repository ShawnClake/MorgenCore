package com.shawnclake.morgencore.core.component.collections.tree.btree;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;
import com.shawnclake.morgencore.core.component.collections.tree.Node;
import com.shawnclake.morgencore.core.component.collections.tree.Tree;

/**
 * Binary Tree
 * @param <T>
 */
public class BinaryTree<T extends AdvancedObject> extends Tree {

    public BinaryTree(BinaryNode<T> root) {
        super(root);
    }

    /**
     * Compute tree height
     * Code taken and modified from: https://www.geeksforgeeks.org/?p=2686
     * @param root
     * @return
     */
    public int height(Node root)
    {
        BinaryNode<T> node = (BinaryNode<T>)root;

        if (node == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(node.getLeft());
            int rheight = height(node.getRight());

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else
                return(rheight+1);
        }
    }

    /**
     * Print the tree from top down, left right
     * Code taken and modified from: https://www.geeksforgeeks.org/?p=2686
     * @return
     */
    public String printBreadthFirstOrder()
    {
        String s = "";
        int h = height(this.getRoot());
        int i;
        for (i=1; i<=h; i++)
            s += printGivenLevel(this.getRoot(), i) + "\n";
        return s;
    }

    /**
     * Print 1 level of the tree
     * Code taken and modified from: https://www.geeksforgeeks.org/?p=2686
     * @param root
     * @param level
     * @return
     */
    public String printGivenLevel (Node root, int level)
    {
        BinaryNode<T> node = (BinaryNode<T>)root;

        if (node == null)
            return "";

        if (level == 1)
            return node.getValue().__str__() + " ";
        else if (level > 1)
        {
            String s = "";
            s += printGivenLevel(node.getLeft(), level-1);
            s += printGivenLevel(node.getRight(), level-1);
            return s;
        }

        return "";
    }

    @Override
    public String __str__() {
        return this.printBreadthFirstOrder();
    }
}
