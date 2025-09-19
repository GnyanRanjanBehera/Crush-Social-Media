package com.crush.crush_post_service.repositories;
import com.crush.crush_post_service.models.entities.ReplyLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyLikeRepo extends JpaRepository<ReplyLike,Integer> {

}
