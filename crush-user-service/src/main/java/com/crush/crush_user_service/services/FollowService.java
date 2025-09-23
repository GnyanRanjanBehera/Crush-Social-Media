package com.crush.crush_user_service.services;
import com.crush.crush_user_service.models.dtos.FollowDto;
import com.crush.crush_user_service.models.dtos.PageableResponse;
import org.springframework.data.domain.Pageable;


public interface FollowService {

    public FollowDto follow(Integer followerId,Integer followingId);

    public void unFollow(Integer followerId,Integer followingId);

    public PageableResponse<FollowDto> followers(Integer userId,int pageNumber,int pageSize,String sortBy, String sortDir);

    public PageableResponse<FollowDto> followings(Integer userId, int pageNumber, int pageSize, String sortBy, String sortDir);
}
