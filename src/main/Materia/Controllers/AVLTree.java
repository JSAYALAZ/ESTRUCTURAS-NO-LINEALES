package main.Materia.Controllers;

import main.Materia.Models.Node;

public class AVLTree {

    private main.Materia.Models.Node root;

    // Obtener la altura de un nodo
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    // Método que obtiene el factor de equilibrio de un nodo
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        } else if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else {
            return node;
        }

        // Actualizar la altura del predecesor o ancestro
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        // Calcular el balance
        int balance = getBalance(node);

        // Imprimir el nodo insertado y su balance
        System.out.println("Nodo insertado: " + node.getValue() + ", Balance: " + balance);

        // Si el nodo está desbalanceado, se tienen 4 casos

        // Caso Izquierda - Izquierda
        if (balance > 1 && value < node.getLeft().getValue()) {
            System.out.println("Rotación a la derecha en el nodo: " + node.getValue() + ", Balance: " + balance);
            Node nuevaRaiz = rightRotate(node);
            System.out.println("Nueva raíz después de rotación a la derecha: " + nuevaRaiz.getValue());
            return nuevaRaiz;
        }

        // Caso Derecha - Derecha
        if (balance < -1 && value > node.getRight().getValue()) {
            System.out.println("Rotación a la izquierda en el nodo: " + node.getValue() + ", Balance: " + balance);
            Node nuevaRaiz = leftRotate(node);
            System.out.println("Nueva raíz después de rotación a la izquierda: " + nuevaRaiz.getValue());
            return nuevaRaiz;
        }

        // Caso Izquierda - Derecha
        if (balance > 1 && value > node.getLeft().getValue()) {
            node.setLeft(leftRotate(node.getLeft()));
            System.out.println("Rotación a la derecha en el nodo: " + node.getValue() + ", Balance: " + balance);
            Node nuevaRaiz = rightRotate(node);
            System.out.println("Nueva raíz después de rotación a la derecha: " + nuevaRaiz.getValue());
            return nuevaRaiz;
        }

        // Caso Derecha - Izquierda
        if (balance < -1 && value < node.getRight().getValue()) {
            node.setRight(rightRotate(node.getRight()));
            System.out.println("Rotación a la izquierda en el nodo: " + node.getValue() + ", Balance: " + balance);
            Node nuevaRaiz = leftRotate(node);
            System.out.println("Nueva raíz después de rotación a la izquierda: " + nuevaRaiz.getValue());
            return nuevaRaiz;
        }

        // Devolver el nodo sin cambios o rotaciones
        return node;
    }

    private Node rightRotate(Node nodeR) {
        Node x = nodeR.getLeft();
        Node temp = x.getRight();

        // Realizar la rotación
        x.setRight(nodeR);
        nodeR.setLeft(temp);

        // Actualizar las alturas
        nodeR.setHeight(Math.max(height(nodeR.getLeft()), height(nodeR.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        // Devolver nueva raíz
        return x;
    }

    private Node leftRotate(Node nodeR) {
        Node y = nodeR.getRight();
        Node temp = y.getLeft();

        // Realizar la rotación
        y.setLeft(nodeR);
        nodeR.setRight(temp);

        // Actualizar las alturas
        nodeR.setHeight(Math.max(height(nodeR.getLeft()), height(nodeR.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    public void insert(int value) {
        System.out.println("Nodo a insertar: " + value);
        root = insert(root, value);
        printTree();
        System.out.println("\n-------\n");
    }

    public void printTree() {
        printTreeNode(root, "", true);
    }

    public void printTreeNode(Node root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.getValue());
            if (root.getLeft() != null || root.getRight() != null) {
                if (root.getLeft() != null) {
                    printTreeNode(root.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "├── null");
                }
                if (root.getRight() != null) {
                    printTreeNode(root.getRight(), prefix + (isLeft ? "│   " : "    "), false);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "└── null");
                }
            }
        }
    }
}
