package com.postsapi.posts.resources;

import com.postsapi.posts.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "Maira", "Email da maria");
        User ze = new User("2", "Ze", "Email do Ze");
        List<User> list = new ArrayList<>(Arrays.asList(maria, ze));

        return ResponseEntity.ok(list);
    }
}
