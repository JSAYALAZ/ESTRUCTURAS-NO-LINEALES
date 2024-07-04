package test.SocialNetwork;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;

import main.Materia.Controllers.SocialNetwork;
import main.Materia.Models.NodeGraphGeneric;
import main.Materia.Models.User;

public class TestSocialNetwork {
    @Test
    public void start(){
        SocialNetwork sn = new SocialNetwork();
        int size = sn.getUsers().size();

        assertEquals(0, size);
    }

    @Test
    public void connectionUser(){
        SocialNetwork sn = new SocialNetwork();
        User user1 = new User("Alice", 30, Arrays.asList("Music", "Art"));
         User user2 = new User("Bob", 25, Arrays.asList("Music", "Sports"));
         NodeGraphGeneric<User> node1 = new NodeGraphGeneric<>(user1);
        NodeGraphGeneric<User> node2 = new NodeGraphGeneric<>(user2);
        sn.addUser(node1);
        sn.addUser(node2);
        sn.addConnection(node1, node2);

        List<String> friendsName = new ArrayList<>();
        for(NodeGraphGeneric<User> friend: node1.getFriends()){
            friendsName.add(friend.getUser().getName());
        }
        assertEquals(1, friendsName.size());
        assertEquals("Bob", friendsName.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> friendsName.get(1));

    }
}
