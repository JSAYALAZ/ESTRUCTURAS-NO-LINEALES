import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.Ejercicio_04_depth.Depth;
import main.Materia.Models.Node;

/**
 *                 4
 *          2             7     
 *      1       3      4      9
 *       
 */

public class ListLevels {
    List<List<Node>> levels = new ArrayList<>();
    Depth depth = new Depth();
    
    public List<List<Node>> listLevels(Node root){
        if (root == null) {
            return levels;
        }
        
        return levels;
    }
}
