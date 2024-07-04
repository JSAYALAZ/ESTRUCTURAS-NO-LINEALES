package main.Materia.Controllers;

import java.util.ArrayList;
import java.util.List;
import main.Materia.Models.NodeGraphGeneric;
import main.Materia.Models.User;

public class SocialNetwork {
    RecommendationEngine recommend = new RecommendationEngine();
    private List<NodeGraphGeneric<User>> users;

    public SocialNetwork() {
        this.users = new ArrayList<>();
    }

    public NodeGraphGeneric<User> addUser(NodeGraphGeneric<User> user) {
        if (!this.getUsers().contains(user)) {
            NodeGraphGeneric<User> newUser = user;
            users.add(newUser);
            return newUser;
        }
        return user;
    }

    public void addConnection(NodeGraphGeneric<User> user1, NodeGraphGeneric<User> user2) {
        user1.addFriend(user2);
        user2.addFriend(user1);
    }

    public void printUsers() {
        System.out.println("\\tUsuarios actuales");
        for (NodeGraphGeneric<User> node : users) {
            System.out.print("Usuario " + node.getUser().getName() + " : ");
            if (node.getFriends().size() == 0)
                System.out.println("Sin amigos aun, agregalos");
            for (NodeGraphGeneric<User> friend : node.getFriends()) {
                System.out.print(" -> " + friend.getUser().getName());
            }
            System.out.println();
        }
    }

    public void printFriendsOfUser(NodeGraphGeneric<User> user) {
        System.out.println("\tAmigos del usuario " + user.getUser().getName());
        user.getUser().printDates();
        if (user.getFriends().size() == 0)
            System.out.println("\nSin amigos aun. \nNo te preocupes busca similutudes con tus intereses");
        for (NodeGraphGeneric<User> friend : user.getFriends()) {
            System.out.print(" -> " + friend.getUser().getName());
        }
        System.out.println();
    }

    public List<NodeGraphGeneric<User>> getUsers() {
        return users;
    }

    public void setUsers(List<NodeGraphGeneric<User>> users) {
        this.users = users;
    }

    public void getRecommendateFriends(NodeGraphGeneric<User> user) {
        System.out.println();
        System.out.print("Amigos que te recommendamos");
        List<User> recommendationToUser1 = recommend.recommendFriends(user, this);
        for (User user1 : recommendationToUser1) {
            System.out.println("");
            user1.printDates();
        }
    }

}
