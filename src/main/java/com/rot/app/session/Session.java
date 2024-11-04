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
    private Date createdAt;
    private Date expiresAt;
    @ManyToMany
    @JoinTable(name = "session_page",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "page_id"))
    private List<SessionPage> pages;
    private String data;

    public Session() {
    }

    public Session(Long id, String sessionId, Date createdAt, Date expiresAt, List<SessionPage> pages, String data) {
        this.id = id;
        this.sessionId = sessionId;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
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
                ", createdAt=" + createdAt +
                ", expiresAt=" + expiresAt +
                ", pages=" + pages +
                ", data='" + data + '\'' +
                '}';
    }
}
