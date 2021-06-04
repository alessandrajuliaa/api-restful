package com.alessandrajulia.apirestful.services;

import com.alessandrajulia.apirestful.domain.Post;
import com.alessandrajulia.apirestful.repository.PostRepository;
import com.alessandrajulia.apirestful.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        if(!post.isPresent()){
            throw new ObjectNotFoundException("Objeto não encontrado!");
        }
        return post.get();
    }

}
