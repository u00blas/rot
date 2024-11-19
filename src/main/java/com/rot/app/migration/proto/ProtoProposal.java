package com.rot.app.migration.proto;

import java.util.Objects;

public class ProtoProposal {


    private String question;
    private String maxScale;
    private String minScale;


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProtoProposal that = (ProtoProposal) o;
        return Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(question);
    }

    @Override
    public String toString() {
        return "ProtoProposal{" +
                "minScale='" + minScale + '\'' +
                ", maxScale='" + maxScale + '\'' +
                "question='" + question + '\'' +
                '}';
    }

    public void setMaxScale(String maxScale) {
        this.maxScale = maxScale;
    }

    public String getMaxScale() {
        return maxScale;
    }

    public void setMinScale(String minScale) {
        this.minScale = minScale;
    }

    public String getMinScale() {
        return minScale;
    }
}
