package com.example.authen.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@ToString
@NoArgsConstructor
@Data
@Getter
@Setter
@AllArgsConstructor
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column (name = "roles")
    private String roles;


}