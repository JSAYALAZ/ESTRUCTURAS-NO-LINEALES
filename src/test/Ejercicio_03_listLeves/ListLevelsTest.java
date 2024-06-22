package test.Ejercicio_03_listLeves;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import main.Ejercicio_03_listLeves.ListLevels;
import main.Materia.Models.Node;

import org.junit.jupiter.api.Test;

public class ListLevelsTest {

    @Test
    public void listLevelsTest() {
        ListLevels listLevels = new ListLevels();
        Node root = new Node(4);
        root.setLeft(new Node(2));
        root.setRight(new Node(7));
        root.getLeft().setLeft(new Node(1));
        root.getLeft().setRight(new Node(3));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(9));

        List<List<Node>> levels = listLevels.listLevels(root);

        assertEquals(3, levels.size());
        assertEquals(4, levels.get(0).get(0).getValue());
        assertEquals(2, levels.get(1).get(0).getValue());
        assertEquals(7, levels.get(1).get(1).getValue());
        assertEquals(1, levels.get(2).get(0).getValue());
        assertEquals(3, levels.get(2).get(1).getValue());
        assertEquals(6, levels.get(2).get(2).getValue());
        assertEquals(9, levels.get(2).get(3).getValue());
    }
}
