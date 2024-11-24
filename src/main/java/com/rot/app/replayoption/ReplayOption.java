package com.rot.app.replayoption;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "replay_options")
public class ReplayOption {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public ReplayOption() {
    }

    public ReplayOption(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReplayOption{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
