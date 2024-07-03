package main;

import java.util.HashSet;

import main.Materia.Controllers.AVLTree;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.Graph;
import main.Materia.Controllers.Sets;
import main.Materia.Models.Node;
import main.Materia.Models.NodeGraph;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Estructuras de Datos NO Lineanes\n");

        runHash();
        // runArbolesBinarios();
        // runAVLTree();
        // runGraph();
    }

    private static void runHash(){
        new Sets();
    }

    private static void runArbolesBinarios() {
        System.out.println("\t\tArboles Binarios\n");

        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));

        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));

        root.getRight().setRight(new Node(6));

        root.getLeft().getLeft().setLeft(new Node(7));
        root.getLeft().getRight().setLeft(new Node(8));

        ArbolBinario arbolBinario = new ArbolBinario();

        System.out.print("IN-ORDER TRAVERSAL: ");
        arbolBinario.inOrderTraversal(root);
        System.out.println();

        System.out.print("PRE-ORDER TRAVERSAL: ");
        arbolBinario.preOrderTraversal(root);
        System.out.println();

        System.out.print("PRE-ORDER TRAVERSAL: ");
        arbolBinario.preOrderIterative(root);
        System.out.println();

        System.out.print("POST-ORDER TRAVERSAL: ");
        arbolBinario.postOrderTraversal(root);
        System.out.println();
        System.out.print("POST-ORDER TRAVERSAL: ");
        arbolBinario.postOrderIterative(root);
        System.out.println();
    }

    private static void runGraph(){
        Graph graph = new Graph();
        NodeGraph node1 = graph.addNode(1);
        NodeGraph node2 = graph.addNode(2);
        NodeGraph node3 = graph.addNode(3);
        NodeGraph node4 = graph.addNode(4);
        NodeGraph node5 = graph.addNode(5);

        graph.addEdge(node1 , node2);
        graph.addEdge(node1 , node3);
        graph.addEdge(node2 , node4);
        graph.addEdge(node4 , node5);

        graph.printGraph();
    }

    private static void runAVLTree(){
         AVLTree tree = new AVLTree();

        int[] values = { 10, 20, 15, 24, 9, 8, 21, 23, 50, 25 };

        for (int value : values) {
            tree.insert(value);
        }
    }

}