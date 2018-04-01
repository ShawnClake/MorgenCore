package com.shawnclake.morgencore.core.component.collections.tree.btree;

import com.shawnclake.morgencore.core.component.collections.tree.btree.bst.BinarySearchTree;
import com.shawnclake.morgencore.core.component.objects.advanced.primitives.AdvancedInteger;
import com.shawnclake.morgencore.core.component.terminal.Output;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void __str__() {
        BinaryNode<AdvancedInteger> bRoot = new BinaryNode<>(new AdvancedInteger(10));
        BinarySearchTree<AdvancedInteger> bst = new BinarySearchTree<>(bRoot);
        bst.add(new AdvancedInteger(5));
        bst.add(new AdvancedInteger(15));
        bst.add(new AdvancedInteger(13));
        bst.add(new AdvancedInteger(17));
        bst.add(new AdvancedInteger(7));
        Output.pln(bst.__str__());

        assertEquals(false, bst.exists(new AdvancedInteger(0)));
        assertEquals(false, bst.exists(new AdvancedInteger(100)));
        assertEquals(false, bst.exists(new AdvancedInteger(25908)));
        assertEquals(true, bst.exists(new AdvancedInteger(10)));
        assertEquals(true, bst.exists(new AdvancedInteger(15)));
        assertEquals(true, bst.exists(new AdvancedInteger(7)));
        assertEquals(true, bst.exists(new AdvancedInteger(13)));
        assertEquals(true, bst.exists(new AdvancedInteger(17)));
    }
}