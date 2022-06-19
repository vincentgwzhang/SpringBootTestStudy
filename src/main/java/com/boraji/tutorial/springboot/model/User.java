package com.boraji.tutorial.springboot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Here we just use messages.properties and ValidationMessages.properties
 * then resolved the error message display
 */
@Data
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue
    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Email
    @Size(max = 256)
    private String email;

    @NotNull
    @Max(255)
    private Integer age;

}
