package main.Materia.Controllers;

import java.util.Stack;

import main.Materia.Models.Node;

public class ArbolBinario {

    public void preOrderIterative(Node root) {
        // Verifica si el nodo raíz es nulo, en cuyo caso no hay nada que recorrer
        if (root == null) {
            return;
        }

        // Crea una pila para manejar los nodos del árbol durante el recorrido
        Stack<Node> stack = new Stack<>();

        // Empuja (push) el nodo raíz en la pila para iniciar el recorrido
        stack.push(root);

        // Continúa el recorrido mientras la pila no esté vacía
        while (!stack.isEmpty()) {
            // Saca (pop) el nodo del tope de la pila
            Node node = stack.pop();

            // Imprime el valor del nodo actual
            System.out.print(node.getValue() + " ");

            // Empuja el hijo derecho primero para que el hijo izquierdo se procese primero
            // Esto se debe a que una pila es LIFO (Last In, First Out)
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }

            // Empuja el hijo izquierdo
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    public void postOrderIterative(Node root) {
        // Verifica si el nodo raíz es nulo, en cuyo caso no hay nada que recorrer
        if (root == null) {
            return;
        }

        // Crea dos pilas para manejar los nodos del árbol durante el recorrido
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        // Empuja el nodo raíz en la primera pila
        stack1.push(root);

        // Continua el recorrido mientras la primera pila no esté vacía
        while (!stack1.isEmpty()) {
            // Saca el nodo del tope de la primera pila y lo empuja en la segunda pila
            Node node = stack1.pop();
            stack2.push(node);

            // Empuja los hijos izquierdo y derecho del nodo en la primera pila
            if (node.getLeft() != null) {
                stack1.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack1.push(node.getRight());
            }
        }

        // Imprime los nodos de la segunda pila, que están en orden post-order
        while (!stack2.isEmpty()) {
            Node node = stack2.pop();
            System.out.print(node.getValue() + " ");
        }
    }

    public void inOrderTraversal(Node node) {
        // Verifica si el nodo actual no es nulo
        if (node != null) {
            // Llama recursivamente al método para recorrer el subárbol izquierdo
            inOrderTraversal(node.getLeft());
            // Imprime el valor del nodo actual
            System.out.print(node.getValue() + " ");
            // Llama recursivamente al método para recorrer el subárbol derecho
            inOrderTraversal(node.getRight());
        }
    }

    public void preOrderTraversal(Node node) {
        // Verifica si el nodo actual no es nulo
        if (node != null) {
            // Imprime el valor del nodo actual
            System.out.print(node.getValue() + " ");
            // Llama recursivamente al método para recorrer el subárbol izquierdo
            preOrderTraversal(node.getLeft());
            // Llama recursivamente al método para recorrer el subárbol derecho
            preOrderTraversal(node.getRight());
        }
    }

    public void postOrderTraversal(Node node) {
        // Verifica si el nodo actual no es nulo
        if (node != null) {
            // Llama recursivamente al método para recorrer el subárbol izquierdo
            postOrderTraversal(node.getLeft());
            // Llama recursivamente al método para recorrer el subárbol derecho
            postOrderTraversal(node.getRight());
            // Imprime el valor del nodo actual
            System.out.print(node.getValue() + " ");
        }
    }

}