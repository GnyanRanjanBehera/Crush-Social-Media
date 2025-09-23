package com.crush.crush_user_service.controllers;
import com.crush.crush_user_service.models.dtos.ApiResponseMessage;
import com.crush.crush_user_service.models.dtos.FollowDto;
import com.crush.crush_user_service.services.FollowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/follow")
public class FollowController {

    private final FollowService followService;

    public FollowController(FollowService followService){
        this.followService=followService;
    }

    @PostMapping("/following")
    public ResponseEntity<FollowDto> follow(
            @RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "followUserId") Integer followUserId
    ){
        FollowDto follow = followService.follow(userId, followUserId);
        return new ResponseEntity<>(follow, HttpStatus.OK);
    }

    @PostMapping("/unFollow")
    public ResponseEntity<ApiResponseMessage> unFollow(
            @RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "unfollowUserId") Integer unfollowUserId
    ){
     followService.unFollow(userId, unfollowUserId);
        ApiResponseMessage unfollowSuccessfully = ApiResponseMessage.builder().message("Unfollow successfully")
                .status(HttpStatus.OK)
                .success(true)
                .build();
        return new ResponseEntity<>(unfollowSuccessfully, HttpStatus.OK);
    }


}
