package com.crush.crush_post_service.repositories;

import com.crush.crush_post_service.models.entities.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepo extends JpaRepository<Reply,Integer> {
}
