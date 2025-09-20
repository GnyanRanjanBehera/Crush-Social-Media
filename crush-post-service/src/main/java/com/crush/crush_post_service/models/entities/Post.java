package com.crush.crush_post_service.models.entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id",nullable = false,unique = true)
    private Integer postId;

    @Column(name = "user_id",nullable = false)
    private Integer userId;

    @Column(name = "caption")
    private String caption;

    @Column(name = "media_url",nullable = false)
    private String mediaUrl;

    @Column(name = "like_count",nullable = false)
    private Long likeCount=0L;

    @Column(name = "comment_count",nullable = false)
    private Long commentCount=0L;

    @Column(name ="share_count" ,nullable = false)
    private Long shareCount=0L;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "is_comment_off",nullable = false)
    private boolean isCommentOff=false;

    @Column(name = "hide_like_count",nullable = false)
    private boolean hideLikeCount=false;

    @Column(name = "hide_share_count",nullable = false)
    private boolean hideShareCount=false;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "post_hashtags",
            joinColumns = @JoinColumn(name="post_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id")
    )
    private List<Hashtag> hashtags;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> comments=new ArrayList<>();

    @OneToMany(mappedBy = "post",cascade =CascadeType.ALL,orphanRemoval = true)
    private List<PostLike> postLikes=new ArrayList<>();

    @OneToMany(mappedBy = "post",cascade =CascadeType.ALL,orphanRemoval = true)
    private List<SharePost> sharePosts=new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
}
