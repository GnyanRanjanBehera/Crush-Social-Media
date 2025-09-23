package com.crush.crush_user_service.repositories;
import com.crush.crush_user_service.models.dtos.PageableResponse;
import com.crush.crush_user_service.models.entities.Follow;
import com.crush.crush_user_service.models.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowRepo extends JpaRepository<Follow,Integer> {
    boolean existsByFollowerAndFollowing(User follower,User following);

    Optional<Follow> findByFollowerAndFollowing(User follower,User following);

    Page<Follow>  findByFollower(User follower, Pageable pageable);

    Page<Follow> findByFollowing(User following,Pageable pageable);
}
