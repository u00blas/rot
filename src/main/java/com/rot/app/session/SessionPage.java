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

    private String description;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "session_page_questions",
            joinColumns = @JoinColumn(name = "page_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<SessionQuestion> sessionQuestions;

    public SessionPage() {
    }


    public SessionPage(Long id, Integer pageId, String description, List<SessionQuestion> sessionQuestions) {
        this.id = id;
        this.pageId = pageId;
        this.description = description;
        this.sessionQuestions = sessionQuestions;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SessionQuestion> getSessionQuestions() {
        return sessionQuestions;
    }

    public void setSessionQuestions(List<SessionQuestion> sessionQuestions) {
        this.sessionQuestions = sessionQuestions;
    }

    @Override
    public String toString() {
        return "SessionPage{" +
                "id=" + id +
                ", pageId=" + pageId +
                ", description='" + description + '\'' +
                ", sessionQuestions=" + sessionQuestions +
                '}';
    }
}
