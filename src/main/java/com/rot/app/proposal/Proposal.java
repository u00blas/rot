package com.rot.app.proposal;

import com.rot.app.replayoption.ReplayOption;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "proposals")
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "min_scale")
    private String minScale;

    @Column(name = "max_scale")
    private String maxScale;

    @ManyToMany
    @Column(name = "replay_options")
    private List<ReplayOption> replayOptions;

    private String description1;
    private String description2;
    private String description3;
    private String description4;
    private String description5;

    public Proposal() {
    }

    public Proposal(Long id, String name, String minScale, String maxScale, List<ReplayOption> replayOptions, String description1, String description2, String description3, String description4, String description5) {
        this.id = id;
        this.name = name;
        this.minScale = minScale;
        this.maxScale = maxScale;
        this.replayOptions = replayOptions;
        this.description1 = description1;
        this.description2 = description2;
        this.description3 = description3;
        this.description4 = description4;
        this.description5 = description5;
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

    public String getMinScale() {
        return minScale;
    }

    public void setMinScale(String minScale) {
        this.minScale = minScale;
    }

    public String getMaxScale() {
        return maxScale;
    }

    public void setMaxScale(String maxScale) {
        this.maxScale = maxScale;
    }

    public List<ReplayOption> getReplayOptions() {
        return replayOptions;
    }

    public void setReplayOptions(List<ReplayOption> replayOptions) {
        this.replayOptions = replayOptions;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getDescription4() {
        return description4;
    }

    public void setDescription4(String description4) {
        this.description4 = description4;
    }

    public String getDescription5() {
        return description5;
    }

    public void setDescription5(String description5) {
        this.description5 = description5;
    }

    @Override
    public String toString() {
        return "Proposal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minScale='" + minScale + '\'' +
                ", maxScale='" + maxScale + '\'' +
                ", replayOptions=" + replayOptions +
                ", description1='" + description1 + '\'' +
                ", description2='" + description2 + '\'' +
                ", description3='" + description3 + '\'' +
                ", description4='" + description4 + '\'' +
                ", description5='" + description5 + '\'' +
                '}';
    }
}