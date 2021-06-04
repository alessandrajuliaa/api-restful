package com.alessandrajulia.apirestful.config;

import com.alessandrajulia.apirestful.domain.Post;
import com.alessandrajulia.apirestful.domain.User;
import com.alessandrajulia.apirestful.dto.AuthorDTO;
import com.alessandrajulia.apirestful.dto.CommentDTO;
import com.alessandrajulia.apirestful.repository.PostRepository;
import com.alessandrajulia.apirestful.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", LocalDate.of(2018,3,21), new AuthorDTO((alex)));
        CommentDTO c2 = new CommentDTO("Aproveite!", LocalDate.of(2018,3,22), new AuthorDTO((bob)));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", LocalDate.of(2018,3,23), new AuthorDTO((alex)));

        p1.getComments().addAll(Arrays.asList(c1,c2));
        p2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(p1,p2));

        maria.getPosts().addAll(Arrays.asList(p1,p2));
        userRepository.save(maria);
    }
}
