package com.alessandrajulia.apirestful.config;

import com.alessandrajulia.apirestful.domain.Post;
import com.alessandrajulia.apirestful.domain.User;
import com.alessandrajulia.apirestful.repository.PostRepository;
import com.alessandrajulia.apirestful.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post p1 = new Post(null, LocalDate.of(2021, 3, 21), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
        Post p2 = new Post(null, LocalDate.of(2021, 3, 23), "Bom dia", "Acordei feliz hoje!", maria);

        userRepository.saveAll(Arrays.asList(maria,alex,bob));
        postRepository.saveAll(Arrays.asList(p1,p2));
    }
}
