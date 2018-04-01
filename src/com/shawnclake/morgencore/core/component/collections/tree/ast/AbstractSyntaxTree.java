package com.shawnclake.morgencore.core.component.collections.tree.ast;

import com.shawnclake.morgencore.core.component.collections.tree.Node;
import com.shawnclake.morgencore.core.component.collections.tree.Tree;

public class AbstractSyntaxTree extends Tree {

    public AbstractSyntaxTree(Node root) {
        super(root);
    }

    @Override
    public int height(Node root) {
        return 0;
    }
}
