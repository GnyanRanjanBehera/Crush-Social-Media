package com.crush.crush_user_service.controllers;
import com.crush.crush_user_service.models.dtos.ApiResponseMessage;
import com.crush.crush_user_service.models.dtos.FollowDto;
import com.crush.crush_user_service.models.dtos.PageableResponse;
import com.crush.crush_user_service.services.FollowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follow")
public class FollowController {

    private final FollowService followService;

    public FollowController(FollowService followService){
        this.followService=followService;
    }

    @PostMapping("/follow")
    public ResponseEntity<FollowDto> follow(
            @RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "followUserId") Integer followUserId
    ){
        FollowDto follow = followService.follow(userId, followUserId);
        return new ResponseEntity<>(follow, HttpStatus.OK);
    }

    @PostMapping("/unFollow")
    public ResponseEntity<ApiResponseMessage> unFollow(
            @RequestParam(name = "followerId") Integer followerId,
            @RequestParam(name = "followingId") Integer followingId
    ){
     followService.unFollow(followerId, followingId);
        ApiResponseMessage unfollowSuccessfully = ApiResponseMessage.builder().message("Unfollow successfully")
                .status(HttpStatus.OK)
                .success(true)
                .build();
        return new ResponseEntity<>(unfollowSuccessfully, HttpStatus.OK);
    }

    @GetMapping("/followers")
    public ResponseEntity<PageableResponse<FollowDto>> followers(
            @RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "taskStatus",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir,
            @PathVariable("userId") Integer userId
    ){
        PageableResponse<FollowDto> followers = followService.followers(userId, pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(followers,HttpStatus.OK);
    }

    @GetMapping("/followings")
    public ResponseEntity<PageableResponse<FollowDto>> following(
            @RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "taskStatus",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir,
            @PathVariable("userId") Integer userId
    ){
        PageableResponse<FollowDto> followers = followService.followings(userId, pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(followers,HttpStatus.OK);
    }


}
