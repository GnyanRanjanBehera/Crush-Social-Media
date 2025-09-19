package com.crush.crush_post_service.models.dtos;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {

    private Integer postId;

    private Integer userId;

    private String caption;

    private String mediaUrl;

    private Long likeCount;

    private Long commentCount;


}
