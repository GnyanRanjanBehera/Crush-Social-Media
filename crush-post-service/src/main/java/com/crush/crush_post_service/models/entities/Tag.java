package com.crush.crush_post_service.models.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id",nullable = false,unique = true)
    private Integer tagId;

    @Column(name = "user_id",nullable = false)
    private Integer userId;

    @Column(name = "tagged_at",nullable = false)
    private LocalDateTime taggedAt=LocalDateTime.now();

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private List<Post> posts;
}
