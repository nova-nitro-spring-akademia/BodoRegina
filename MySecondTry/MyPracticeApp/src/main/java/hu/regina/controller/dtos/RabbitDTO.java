package hu.regina.controller.dtos;

import java.util.List;

public class RabbitDTO {
    private int id;
    private String name;

    private List<RabbitDTO> friends;

    private HomeDTO homeDTO;

    private int levelOfFullness;

    private String eatingStrategy;



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

    public List<RabbitDTO> getFriends() {
        return friends;
    }

    public void setFriends(List<RabbitDTO> friends) {
        this.friends = friends;
    }

    public HomeDTO getHomeDTO() {
        return homeDTO;
    }

    public void setHomeDTO(HomeDTO homeDTO) {
        this.homeDTO = homeDTO;
    }

    public int getLevelOfFullness() {
        return levelOfFullness;
    }

    public void setLevelOfFullness(int levelOfFullness) {
        this.levelOfFullness = levelOfFullness;
    }

    public String getEatingStrategy() {
        return eatingStrategy;
    }

    public void setEatingStrategy(String eatingStrategy) {
        this.eatingStrategy = eatingStrategy;
    }
}
