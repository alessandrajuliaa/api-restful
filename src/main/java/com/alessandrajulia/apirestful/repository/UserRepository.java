package com.alessandrajulia.apirestful.repository;

import com.alessandrajulia.apirestful.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
