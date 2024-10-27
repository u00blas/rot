package com.rot.app.asking;

import java.util.List;

public class Asking {
    private String question;
    private List<String> proposals;
    private String answer;

    public Asking(String question, List<String> proposals, String answer) {
        this.question = question;
        this.proposals = proposals;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getProposals() {
        return proposals;
    }

    public void setProposals(List<String> proposals) {
        this.proposals = proposals;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Asking{" +
                "question='" + question + '\'' +
                ", proposals=" + proposals +
                ", answer='" + answer + '\'' +
                '}';
    }
}
