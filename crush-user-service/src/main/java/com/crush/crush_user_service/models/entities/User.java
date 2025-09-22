package com.crush.crush_user_service.models.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id",nullable = false,unique = true)
    private Integer userId;

    @Column(name = "name",nullable = false)
    private  String name;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt=LocalDateTime.now();

    @OneToMany(mappedBy = "following", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Follow> followers = new HashSet<>();

    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Follow> followings = new HashSet<>();

}
