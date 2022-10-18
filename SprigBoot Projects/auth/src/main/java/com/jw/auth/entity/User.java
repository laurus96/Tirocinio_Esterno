package com.jw.auth.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER) //loads all of the roles when a user is loaded
    private Collection<Role> roles = new ArrayList<>();

}
