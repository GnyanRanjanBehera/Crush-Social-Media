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
@Table(name = "reply")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reply_id",nullable = false,unique = true)
    private Integer replyId;

    @Column(name = "reply",nullable = false)
    private String reply;

    @Column(name = "crated_date",nullable = false)
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "com_id",nullable = false)
    private Comment comment;

    @OneToMany(mappedBy = "reply",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ReplyLike> replyLikes=new ArrayList<>();

}
