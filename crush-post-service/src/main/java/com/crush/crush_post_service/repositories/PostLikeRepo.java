package com.crush.crush_post_service.repositories;

import com.crush.crush_post_service.models.entities.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeRepo extends JpaRepository<PostLike,Integer> {
}
