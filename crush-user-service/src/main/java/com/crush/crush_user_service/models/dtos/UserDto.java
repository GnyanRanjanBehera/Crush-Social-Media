package com.crush.crush_user_service.models.dtos;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDto {

    private Integer userId;

    private String email;

    private String name;
}
