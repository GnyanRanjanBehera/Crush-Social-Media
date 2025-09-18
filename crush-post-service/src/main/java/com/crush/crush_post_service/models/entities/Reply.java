package com.crush.crush_post_service.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    private Integer replyId;

    @Column(name = "reply",nullable = false)
    private String reply;

    @Column(name = "crated_date",nullable = false)
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "com_id",nullable = false)
    private Comment comment;

}
