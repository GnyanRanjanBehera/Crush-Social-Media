package com.crush.crush_user_service.services.impl;
import com.crush.crush_user_service.exceptions.BadApiRequestException;
import com.crush.crush_user_service.exceptions.ResourceNotFoundException;
import com.crush.crush_user_service.models.dtos.FollowDto;
import com.crush.crush_user_service.models.dtos.PageableResponse;
import com.crush.crush_user_service.models.entities.Follow;
import com.crush.crush_user_service.models.entities.User;
import com.crush.crush_user_service.repositories.FollowRepo;
import com.crush.crush_user_service.repositories.UserRepo;
import com.crush.crush_user_service.services.FollowService;
import com.crush.crush_user_service.utils.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    public PageableResponse<FollowDto> followers(Integer userId,int pageNumber,int pageSize,String sortBy, String sortDir) {
        User user = userRepo.findById(userId).orElseThrow(() -> new BadApiRequestException("user not found by this id"));
        Sort sort = (sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
        Page<Follow> byFollower = followRepo.findByFollower(user,pageable);
        return Helper.getPageableResponse(byFollower, FollowDto.class);
    }

    @Override
    public PageableResponse<FollowDto> followings(Integer userId,int pageNumber,int pageSize,String sortBy, String sortDir) {
        User user = userRepo.findById(userId).orElseThrow(() -> new BadApiRequestException("user not found by this id"));
        Sort sort = (sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
        Page<Follow> byFollower = followRepo.findByFollowing(user,pageable);
        return Helper.getPageableResponse(byFollower, FollowDto.class);
    }
}
