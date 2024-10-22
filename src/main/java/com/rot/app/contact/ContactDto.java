package com.rot.app.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class ContactDto {

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Email
    private String email;

    private String phone;
    private String comment;

    public ContactDto() {

    }

    public ContactDto(String name, String email, String phone, String comment) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.comment = comment;
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
}
