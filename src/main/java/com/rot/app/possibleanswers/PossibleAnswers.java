package com.rot.app.possibleanswers;

public class PossibleAnswers {

    private Long id;
    private String minScale;
    private String maxScale;
    private String description1;
    private String description2;
    private String description3;
    private String description4;
    private String description5;

    public PossibleAnswers() {
    }

    public PossibleAnswers(Long id, String minScale, String maxScale, String description1, String description2, String description3, String description4, String description5) {
        this.id = id;
        this.minScale = minScale;
        this.maxScale = maxScale;
        this.description1 = description1;
        this.description2 = description2;
        this.description3 = description3;
        this.description4 = description4;
        this.description5 = description5;
    }

    public PossibleAnswers(String minScale, String maxScale, String description1, String description2, String description3, String description4, String description5) {
        this.minScale = minScale;
        this.maxScale = maxScale;
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
        return "PossibleAnswers{" +
                "id=" + id +
                ", minScale='" + minScale + '\'' +
                ", maxScale='" + maxScale + '\'' +
                ", description1='" + description1 + '\'' +
                ", description2='" + description2 + '\'' +
                ", description3='" + description3 + '\'' +
                ", description4='" + description4 + '\'' +
                ", description5='" + description5 + '\'' +
                '}';
    }
}
