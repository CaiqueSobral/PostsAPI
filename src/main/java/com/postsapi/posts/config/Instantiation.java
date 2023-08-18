package com.postsapi.posts.config;

import com.postsapi.posts.domain.Post;
import com.postsapi.posts.domain.User;
import com.postsapi.posts.domain.dto.AuthorDTO;
import com.postsapi.posts.repository.PostRepository;
import com.postsapi.posts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PostRepository postRepo;


    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepo.deleteAll();
        postRepo.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepo.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viage", "Vou pra SP, vlw",
                new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("24/05/2018"), "Bom dia", "Acordei feliz",
                new AuthorDTO(maria));
        Post post3 = new Post(null, sdf.parse("14/09/2019"), "Emprego novo",
                "To de emprego novo", new AuthorDTO(bob));

        postRepo.saveAll(Arrays.asList(post1, post2, post3));
        maria.getPosts().addAll(Arrays.asList(post1, post2));
        bob.getPosts().add(post3);
        userRepo.saveAll(Arrays.asList(maria, bob));
    }
}
