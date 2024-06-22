package main.Ejercicio_04_depth;

import main.Materia.Models.Node;

public class Depth {
    public int maxDepth(Node root){
        if(root == null) return 0;
        int depthLeft = maxDepth(root)+1;
        int depthRigth = maxDepth(root)+1;
        return Math.max(depthLeft,depthRigth);
    }
}
