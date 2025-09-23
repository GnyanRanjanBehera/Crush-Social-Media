package com.crush.crush_user_service.services;
import com.crush.crush_user_service.models.dtos.FollowDto;



public interface FollowService {

    public FollowDto follow(Integer followerId,Integer followingId);

    public void unFollow(Integer followerId,Integer followingId);


}
