package main.Materia.Models;

import java.util.List;

public class User {
    private String name;
    private int age;
    List<String> interests;
    List<User> friends;

    public User(String name, int age, List<String> interests) {
        this.name = name;
        this.age = age;
        this.interests = interests;

    }

    public void printDates(){
        System.out.print("Usuario: "+this.getName()+", edad: "+this.getAge());
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
    
}
