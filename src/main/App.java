package main;

import main.Materia.Controllers.ArbolBinario;
import main.Materia.Models.Node;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Estructuras de Datos NO Lineanes\n");

        runArbolesBinarios();
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
}