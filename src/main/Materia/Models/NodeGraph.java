package main.Materia.Models;

import java.util.LinkedList;
import java.util.List;

public class NodeGraph {
    private int value;
    private List<NodeGraph> neighbors;

    public NodeGraph(int value){
        this.value = value;
        this.neighbors = new LinkedList<>();
    }

    public int getValue(){
        return this.value;
    }

    public List<NodeGraph> getNeighbors(){
        return this.neighbors;
    }

    public void addNeighbor (NodeGraph neighbor){
        this.neighbors.add(neighbor);
    }
}
