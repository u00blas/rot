package com.rot.app.migration.proto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProtoSubquestion {

    private String question;
    private String page;
    private String numberI;
    private String numberJ;
    private String numberK;
    private List<ProtoProposal> proposals = new ArrayList<>();

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getNumberI() {
        return numberI;
    }

    public void setNumberI(String numberI) {
        this.numberI = numberI;
    }

    public String getNumberJ() {
        return numberJ;
    }

    public void setNumberJ(String numberJ) {
        this.numberJ = numberJ;
    }

    public String getNumberK() {
        return numberK;
    }

    public void setNumberK(String numberK) {
        this.numberK = numberK;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<ProtoProposal> getProposals() {
        return proposals;
    }

    public void setProposals(List<ProtoProposal> proposals) {
        this.proposals = proposals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProtoSubquestion that = (ProtoSubquestion) o;
        return Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(question);
    }

    @Override
    public String toString() {
        return "ProtoSubquestion{" +
                "question='" + question + '\'' +
                ", page='" + page + '\'' +
                ", numberI='" + numberI + '\'' +
                ", numberJ='" + numberJ + '\'' +
                ", numberK='" + numberK + '\'' +
                ", proposals=" + proposals +
                '}';
    }
}
