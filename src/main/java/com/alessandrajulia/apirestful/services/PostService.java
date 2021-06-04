package com.alessandrajulia.apirestful.services;

import com.alessandrajulia.apirestful.domain.Post;
import com.alessandrajulia.apirestful.repository.PostRepository;
import com.alessandrajulia.apirestful.services.exception.ObjectNotFoundException;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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

    public List<Post> findByTitle(String text){
        return repository.searchTitle(text);
    }

    public List<Post> searchTextDate(String text, LocalDate minDate, LocalDate maxDate){
        return repository.searchTextDate(text, minDate, maxDate);
    }

}
