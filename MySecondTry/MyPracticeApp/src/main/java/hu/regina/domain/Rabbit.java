package hu.regina.domain;

import hu.regina.domain.eatingstrategy.EatingStrategy;
import hu.regina.domain.food.Food;
import hu.regina.domain.eatingstrategy.MyEatingStrategy;

import java.util.List;

public class Rabbit {

    private int id;
    private String name;

    private List<Rabbit> friends;

    private Home home;

    private int levelOfFullness;

    private MyEatingStrategy eatingStrategy;

    public Rabbit(MyEatingStrategy eatingStrategy) {
        this.eatingStrategy = eatingStrategy;
    }

    public void feedFood(Food f){
        int feedEaten = eatingStrategy.execute(f);

        if (levelOfFullness + feedEaten <= 100)
            levelOfFullness += f.getFeedingValue();
        else{
            levelOfFullness = 100;
        }

        System.out.println("The rabbit is " + levelOfFullness + "% full.");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Rabbit> getFriends() {
        return friends;
    }

    public void setFriends(List<Rabbit> friends) {
        this.friends = friends;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public int getLevelOfFullness() {
        return levelOfFullness;
    }

    public void setLevelOfFullness(int levelOfFullness) {
        this.levelOfFullness = levelOfFullness;
    }

    public MyEatingStrategy getEatingStrategy() {
        return eatingStrategy;
    }

    public void setEatingStrategy(MyEatingStrategy eatingStrategy) {
        this.eatingStrategy = eatingStrategy;
    }
}
