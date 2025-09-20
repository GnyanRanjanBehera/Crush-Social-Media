package com.crush.crush_post_service.repositories;
import com.crush.crush_post_service.models.entities.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagRepo extends JpaRepository<Hashtag,Integer> {

}
