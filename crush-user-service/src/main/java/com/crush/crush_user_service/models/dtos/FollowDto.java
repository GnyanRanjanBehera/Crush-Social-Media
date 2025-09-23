package com.crush.crush_user_service.models.dtos;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowDto {

    private Integer followId;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-YYYY")
    private LocalDateTime followedAt;

    private UserDto follower;

    private UserDto following;
}
