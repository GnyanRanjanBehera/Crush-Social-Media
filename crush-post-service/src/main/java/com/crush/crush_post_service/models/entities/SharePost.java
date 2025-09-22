package com.crush.crush_post_service.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "share_post")
public class SharePost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "share_post_id",nullable = false,unique = true)
    private Integer sharePostId;

    @Column(name = "user_id",nullable = false)
    private Integer userId;

    @Column(name = "shared_at",nullable = false)
    private LocalDateTime sharedAt=LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
