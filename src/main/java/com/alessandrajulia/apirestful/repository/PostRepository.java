package com.alessandrajulia.apirestful.repository;

import com.alessandrajulia.apirestful.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
