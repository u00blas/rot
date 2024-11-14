package com.rot.app.session;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "session_proposals")
public class SessionProposal {

    @Id
    @GeneratedValue
    private Long id;

    private String description;
    private String minScale;
    private String maxScale;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "session_proposal_proposal",
            joinColumns = @JoinColumn(name = "proposal_id"),
            inverseJoinColumns = @JoinColumn(name = "session_proposal_id"))
    private List<SubProposal> subProposals;

    public SessionProposal() {
    }

    public SessionProposal(Long id, String description, String minScale, String maxScale, List<SubProposal> subProposals) {
        this.id = id;
        this.description = description;
        this.minScale = minScale;
        this.maxScale = maxScale;
        this.subProposals = subProposals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<SubProposal> getSubProposals() {
        return subProposals;
    }

    public void setSubProposals(List<SubProposal> subProposals) {
        this.subProposals = subProposals;
    }

    @Override
    public String toString() {
        return "SessionProposal{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", minScale='" + minScale + '\'' +
                ", maxScale='" + maxScale + '\'' +
                ", subProposals=" + subProposals +
                '}';
    }
}
