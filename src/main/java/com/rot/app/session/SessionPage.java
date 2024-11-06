package com.rot.app.session;

import com.rot.app.question.Question;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "session_pages")
public class SessionPage {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "page_id")
    private Integer pageId;
    private String data;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "session_page_question",
            joinColumns = @JoinColumn(name = "page_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<SessionQuestion> questions;


    public SessionPage() {
    }

    public SessionPage(Long id, Integer pageId, String data, List<SessionQuestion> questions) {
        this.id = id;
        this.pageId = pageId;
        this.data = data;
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<SessionQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<SessionQuestion> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "SessionPage{" +
                "id=" + id +
                ", pageId=" + pageId +
                ", data='" + data + '\'' +
                ", questions=" + questions +
                '}';
    }
}
