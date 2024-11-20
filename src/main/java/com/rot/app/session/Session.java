package com.rot.app.session;

import com.rot.app.person.Person;
import com.rot.app.surveys.Survey;
import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String sessionName;
    private Date creationDate;
    private Date expirationDate;
    private Date lastAccessDate;
    @ManyToOne
    private Person participant;
    @ManyToOne
    private Survey survey;

    public Session() {
    }

    public Session(Long id, String sessionName, Date creationDate, Date expirationDate, Date lastAccessDate, Person participant, Survey survey) {
        this.id = id;
        this.sessionName = sessionName;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.lastAccessDate = lastAccessDate;
        this.participant = participant;
        this.survey = survey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(Date lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public Person getParticipant() {
        return participant;
    }

    public void setParticipant(Person participant) {
        this.participant = participant;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", sessionName='" + sessionName + '\'' +
                ", creationDate=" + creationDate +
                ", expirationDate=" + expirationDate +
                ", lastAccessDate=" + lastAccessDate +
                ", participant=" + participant +
                ", survey=" + survey +
                '}';
    }
}
