package com.mobigen.lecture.user.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Schema(name = "User Info", description = "User Info - DTO")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Schema(name="name", description = "User Name", required = true, example = "Hong Gil-Dong", nullable = false)
    private String name;

    @Schema(name="email", description = "User Email", required = true, example = "email@email.com", nullable = false)
    private String email;

    @Schema(name="password", description = "User Password", required = true, example = "*******", nullable = false)
    private String password;
}
