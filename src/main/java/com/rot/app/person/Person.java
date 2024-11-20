package com.rot.app.person;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String phone;
    private String comment;

    public Person() {
    }

    public Person(Long id, String name, String email, String phone, String comment) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
