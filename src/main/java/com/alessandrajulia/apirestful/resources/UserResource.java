package com.alessandrajulia.apirestful.resources;

import com.alessandrajulia.apirestful.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User u1 = new User("1", "Ale", "ale@gmail.com");
        User u2 = new User("2", "Mary", "mary@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(u1, u2));
        return ResponseEntity.ok().body(list);
    }
}
