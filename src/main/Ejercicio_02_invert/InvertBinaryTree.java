package main.Ejercicio_02_invert;

import main.Materia.Models.Node;

public class InvertBinaryTree {
    public Node invertTree(Node root) {
        if (root == null) return null;

        Node temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        invertTree(root.getLeft());
        invertTree(root.getRight());
        return root;
    }
}
