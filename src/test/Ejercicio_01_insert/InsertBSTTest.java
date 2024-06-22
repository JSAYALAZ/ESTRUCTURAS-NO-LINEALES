package test.Ejercicio_01_insert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import main.Ejercicio_01_insert.InsertBST;
import main.Materia.Models.Node;

import org.junit.jupiter.api.Test;

public class InsertBSTTest {

    @Test
    public void bstInsertionTest() {
        InsertBST bstInsertion = new InsertBST();
        int[] values = { 5, 3, 7, 2, 4, 6, 8 };

        Node root = null;
        for (int value : values) {
            root = bstInsertion.insert(root, value);
        }

        assertEquals(5, root.getValue());
        assertEquals(3, root.getLeft().getValue());
        assertEquals(7, root.getRight().getValue());
        assertEquals(2, root.getLeft().getLeft().getValue());
        assertEquals(4, root.getLeft().getRight().getValue());
        assertEquals(6, root.getRight().getLeft().getValue());
        assertEquals(8, root.getRight().getRight().getValue());
    }

    @Test
    public void insertSingleNodeTest() {
        InsertBST bstInsertion = new InsertBST();
        Node root = bstInsertion.insert(null, 10);

        assertEquals(10, root.getValue());
        assertNull(root.getLeft());
        assertNull(root.getRight());
    }

    @Test
    public void insertMultipleNodesTest() {
        InsertBST bstInsertion = new InsertBST();
        Node root = null;
        root = bstInsertion.insert(root, 10);
        root = bstInsertion.insert(root, 5);
        root = bstInsertion.insert(root, 15);

        assertEquals(10, root.getValue());
        assertEquals(5, root.getLeft().getValue());
        assertEquals(15, root.getRight().getValue());
    }

}
