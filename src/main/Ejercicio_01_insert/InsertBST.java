package main.Ejercicio_01_insert;

import main.Materia.Models.Node;

public class InsertBST {
    public Node insert(Node root, int value){
        if(root == null) return new Node(value);
        if(value < root.getValue()) root.setLeft(insert(root.getLeft(), value));
        else if(value > root.getValue()) root.setRight(insert(root.getRight(), value));
        return root;
    }
}
