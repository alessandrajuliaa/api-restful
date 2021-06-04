package com.alessandrajulia.apirestful.resources;

import com.alessandrajulia.apirestful.domain.Post;
import com.alessandrajulia.apirestful.repository.PostRepository;
import com.alessandrajulia.apirestful.resources.util.URL;
import com.alessandrajulia.apirestful.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.alessandrajulia.apirestful.resources.util.URL.decodeDate;


@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @Autowired
    private PostRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/titledatesearch")
    public ResponseEntity<List<Post>> findByTitleDate(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate){
        text = URL.decodeParam(text);
        Date min = URL.decodeDate(minDate, new Date(0L));
        Date max = URL.decodeDate(maxDate, new Date());

        List<Post> list = repository.searchTextDate(text, min, max);
        return ResponseEntity.ok().body(list);
    }
}