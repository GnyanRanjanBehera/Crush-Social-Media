package com.crush.crush_user_service.services.impl;
import com.crush.crush_user_service.exceptions.BadApiRequestException;
import com.crush.crush_user_service.exceptions.ResourceNotFoundException;
import com.crush.crush_user_service.models.dtos.FollowDto;
import com.crush.crush_user_service.models.entities.Follow;
import com.crush.crush_user_service.models.entities.User;
import com.crush.crush_user_service.repositories.FollowRepo;
import com.crush.crush_user_service.repositories.UserRepo;
import com.crush.crush_user_service.services.FollowService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class FollowServiceImpl implements FollowService {
    private  final UserRepo userRepo;
    private final FollowRepo followRepo;
    private ModelMapper mapper;
    public  FollowServiceImpl(UserRepo userRepo,FollowRepo followRepo){
        this.userRepo=userRepo;
        this.followRepo=followRepo;
    }

    @Override
    public FollowDto follow(Integer followerId,Integer followingId) {
        if(followerId.equals(followingId)){
            throw  new BadApiRequestException("You can not follow yourself");
        }
        User follower = userRepo.findById(followerId).orElseThrow(() -> new BadApiRequestException("user not found by this followerId"));
        User following = userRepo.findById(followingId).orElseThrow(() -> new BadApiRequestException("user not found by this followingId"));
        boolean alreadyFollowing = followRepo.existsByFollowerAndFollowing(follower, following);
        if(alreadyFollowing){
            throw  new BadApiRequestException("Already following this user");
        }
        Follow build = Follow.builder()
                .follower(follower)
                .following(following)
                .build();
        Follow save = followRepo.save(build);
        return mapper.map(save,FollowDto.class);
    }


    @Override
    public void unFollow(Integer followerId,Integer followingId) {
        User follower = userRepo.findById(followerId)
                .orElseThrow(() -> new BadApiRequestException("Follower user not found"));

        User following = userRepo.findById(followingId)
                .orElseThrow(() -> new BadApiRequestException("Following user not found"));

        Follow follow = followRepo.findByFollowerAndFollowing(follower, following)
                .orElseThrow(() -> new BadApiRequestException("Not following this user"));
        followRepo.delete(follow);
    }
}
