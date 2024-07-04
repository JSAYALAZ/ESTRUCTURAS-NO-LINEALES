package main.Materia.Models;

import java.util.LinkedList;
import java.util.List;

public class NodeGraphGeneric<T> {
    private T user;
    private List<NodeGraphGeneric<T>> friends;

    public NodeGraphGeneric(T user){
        this.user = user;
        this.friends = new LinkedList<>();
    }

    public T getUser(){
        return this.user;
    }

    public List<NodeGraphGeneric<T>> getFriends(){
        return this.friends;
    }

    public void addFriend (NodeGraphGeneric<T> friend){
        this.friends.add(friend);
    }
}
