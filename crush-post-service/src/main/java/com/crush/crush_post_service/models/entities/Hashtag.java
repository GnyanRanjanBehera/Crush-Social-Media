package com.crush.crush_post_service.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hashtag")
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hashtag_id",unique = true,nullable = false)
    private Integer hashtagId;

    @Column(name = "tag",unique = true)
    private String tag;

    @ManyToMany(mappedBy = "hashtags", fetch = FetchType.LAZY)
    private List<Post> posts;

}
