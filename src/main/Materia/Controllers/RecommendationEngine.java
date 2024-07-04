package main.Materia.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.Materia.Models.NodeGraphGeneric;
import main.Materia.Models.User;

public class RecommendationEngine {

    public RecommendationEngine(){}
    public List<User> recommendFriends(NodeGraphGeneric<User> user, SocialNetwork graph){
        List<User> recommendations = new ArrayList<>(); 
        for(NodeGraphGeneric<User> profile : graph.getUsers()){
           NodeGraphGeneric<User> potentialFriend = profile;
           if(!user.getFriends().contains(potentialFriend)&&!user.getUser().equals((potentialFriend))){
                double similarity = calculateSimilarity(user.getUser(), potentialFriend.getUser());
                if(similarity>0.3){
                    recommendations.add(potentialFriend.getUser());
                }
           }
        }
        return recommendations;
    }

    public double calculateSimilarity(User user1, User user2){
        Set<String> interests1 = new HashSet<>(user1.getInterests());
        Set<String> interests2 = new HashSet<>(user2.getInterests());
        Set<String> intercections = new HashSet<>(interests1);
        intercections.retainAll(interests2);
        Set<String> union = new HashSet<>(interests1);
        union.addAll(interests2);
        double resp = (double) intercections.size()/union.size();
        return resp;
    }
}
