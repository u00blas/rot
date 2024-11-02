package com.rot.app.appuser;

import jakarta.validation.constraints.NotEmpty;

public class RegisterDto {
@NotEmpty


    private String firstName;
    private String lastName;
    private String email;


    private String password;
}
