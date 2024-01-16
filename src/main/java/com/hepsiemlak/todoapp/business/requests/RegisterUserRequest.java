package com.hepsiemlak.todoapp.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequest {
    @NotNull
    @NotBlank
    @Size(min = 4, max = 20)
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 20)
    private String password;
}
