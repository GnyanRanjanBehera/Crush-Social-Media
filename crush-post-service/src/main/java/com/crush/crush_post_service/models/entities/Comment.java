package com.crush.crush_post_service.models.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comment")
public class Comment {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "com_id",unique = true,nullable = false)
    private Integer comId;

    @Column(name = "user_id",nullable = false)
    private Integer userId;

    @Column(name = "comment",nullable = false)
    private String comment;

    @Column(name = "comment_like_count",nullable = false)
    private Long commentLikeCount=0L;

    @Column(name = "reply_count",nullable = false)
    private Long replyCount=0L;

    @Column(name = "created_date",nullable = false)
    private Date createdDate;

    @OneToMany(mappedBy = "comment",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Reply> replies=new ArrayList<>();

    @OneToMany(mappedBy = "comment",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CommentLike> commentLikes=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "post_id",nullable = false)
    private Post post;


}
