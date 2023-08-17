package com.postsapi.posts.resources;

import com.postsapi.posts.domain.User;
import com.postsapi.posts.domain.dto.UserDTO;
import com.postsapi.posts.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){

        List<UserDTO> dtoList = userService.findAll().
                stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }
}
