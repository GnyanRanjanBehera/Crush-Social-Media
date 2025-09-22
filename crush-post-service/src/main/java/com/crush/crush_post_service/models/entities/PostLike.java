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
@Table(name = "post_like")
public class PostLike{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "like_id",unique = true,nullable = false)
    private Integer postLikeId;

    @Column(name = "user_id",nullable = false)
    private Integer userId;

    @Column(name = "liked_At",nullable = false)
    private LocalDateTime likedAt=LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "post_id",nullable = false)
    private Post post;
}
