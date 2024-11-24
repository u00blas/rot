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
    private String description;

    public Proposal() {
    }

    public Proposal(Long id, String name, String minScale, String maxScale, List<ReplayOption> replayOptions, String description) {
        this.id = id;
        this.name = name;
        this.minScale = minScale;
        this.maxScale = maxScale;
        this.replayOptions = replayOptions;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Proposal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minScale='" + minScale + '\'' +
                ", maxScale='" + maxScale + '\'' +
                ", replayOptions=" + replayOptions +
                ", description='" + description + '\'' +
                '}';
    }
}