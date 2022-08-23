package hu.regina.data.repositories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RabbitEntity {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    private String name;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
