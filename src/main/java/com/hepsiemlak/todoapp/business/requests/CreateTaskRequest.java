package com.hepsiemlak.todoapp.business.requests;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskRequest {
    @NotNull
    @NotBlank
    @Size(min = 1, max = 300)
    private String desc;
    private Long userId;
}
