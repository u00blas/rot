package com.rot.app.session;

import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "session_id")
    private String sessionId;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "session_page",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "page_id"))
    private List<SessionPage> pages;
    private String data;

    public Session() {
    }

    public Session(Long id, String sessionId, List<SessionPage> pages, String data) {
        this.id = id;
        this.sessionId = sessionId;
        this.pages = pages;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<SessionPage> getPages() {
        return pages;
    }

    public void setPages(List<SessionPage> pages) {
        this.pages = pages;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", sessionId='" + sessionId + '\'' +
                ", pages=" + pages +
                ", data='" + data + '\'' +
                '}';
    }
}