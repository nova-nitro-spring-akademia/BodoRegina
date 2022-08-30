package hu.regina.controller.dtos;


import hu.regina.validation.UniqueHomeID;

import javax.validation.constraints.NotBlank;

public class HomeDTO {


    @UniqueHomeID
    private int id;

    @NotBlank
    private String location;


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
