package com.crush.crush_post_service.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "reply_like")
public class ReplyLike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reply_like_id",nullable = false,unique = true)
    private Integer replyLikeId;

    @Column(name = "user_id",unique = true,nullable = false)
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "reply_id",nullable = false)
    private Reply reply;


}
