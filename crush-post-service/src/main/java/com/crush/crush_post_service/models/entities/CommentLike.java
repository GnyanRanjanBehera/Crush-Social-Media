package com.crush.crush_post_service.models.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comment_like")
public class CommentLike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "com_like_id",nullable = false,unique = true)
    private Integer comLikeId;

    @Column(name = "user_id",unique = true,nullable = false)
    private Integer userId;

    @Column(name = "liked_at",nullable = false)
    private LocalDateTime likedAt=LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "com_id",nullable = false)
    private Comment comment;



}
