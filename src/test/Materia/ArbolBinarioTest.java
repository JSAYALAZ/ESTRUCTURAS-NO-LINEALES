package test.Materia;

import org.junit.jupiter.api.Test;

import main.Materia.Controllers.ArbolBinario;
import main.Materia.Models.Node;

/*
*          1
*      2       3
*   4     5      6
* 7     8
*/
public class ArbolBinarioTest {
  @Test
  public void test() {
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

  }
}