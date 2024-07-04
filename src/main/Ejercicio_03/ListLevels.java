package main.Ejercicio_03;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.Materia.Models.Node;

public class ListLevels {
    List<List<Node>> levels = new ArrayList<>();
    public List<List<Node>> listLevels(Node root) {
        if (root == null) {
            return levels;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Node> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode);
                
                if (currentNode.getLeft() != null) {
                    queue.offer(currentNode.getLeft());
                }
                
                if (currentNode.getRight() != null) {
                    queue.offer(currentNode.getRight());
                }
            }
            
            levels.add(currentLevel);
        }
        
        return levels;
    }
}