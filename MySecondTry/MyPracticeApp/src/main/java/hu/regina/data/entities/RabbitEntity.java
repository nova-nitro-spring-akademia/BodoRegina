package hu.regina.data.entities;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
public class RabbitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int levelOfFullness;

    //(fetch = FetchType.EAGER)

    @ManyToMany
    @Nullable
    private List<RabbitEntity> friends;

    @OneToOne(cascade = CascadeType.ALL)
    @Nullable
    private HomeEntity home;

    private String eatingStrategy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevelOfFullness() {
        return levelOfFullness;
    }

    public void setLevelOfFullness(int levelOfFullness) {
        this.levelOfFullness = levelOfFullness;
    }

    public HomeEntity getHome() {
        return home;
    }

    public void setHome(HomeEntity home) {
        this.home = home;
    }

    public String getEatingStrategy() {
        return eatingStrategy;
    }

    public void setEatingStrategy(String eatingStrategy) {
        this.eatingStrategy = eatingStrategy;
    }

    public List<RabbitEntity> getFriends() {
        return friends;
    }

    public void setFriends(List<RabbitEntity> friends) {
        this.friends = friends;
    }
}
