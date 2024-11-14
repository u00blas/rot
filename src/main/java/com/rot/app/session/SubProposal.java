package com.rot.app.session;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sub_proposals")
public class SubProposal {

    @Id
    @GeneratedValue
    private Long id;
    private String proposalLabel;

    public SubProposal() {
    }

    public SubProposal(Long id, String proposalLabel) {
        this.id = id;
        this.proposalLabel = proposalLabel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProposalLabel() {
        return proposalLabel;
    }

    public void setProposalLabel(String proposalLabel) {
        this.proposalLabel = proposalLabel;
    }

    @Override
    public String toString() {
        return "SubProposal{" +
                "id=" + id +
                ", proposalLabel='" + proposalLabel + '\'' +
                '}';
    }
}
