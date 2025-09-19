package com.crush.crush_post_service.repositories;
import com.crush.crush_post_service.models.entities.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentLikeRepo extends JpaRepository<CommentLike,Integer> {
}
