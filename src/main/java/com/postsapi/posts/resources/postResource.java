package com.postsapi.posts.resources;

import com.postsapi.posts.domain.Post;
import com.postsapi.posts.resources.util.URL;
import com.postsapi.posts.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class postResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = postService.findById(id);

        return ResponseEntity.ok(obj);
    }

    @GetMapping(value="/title")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text){
        text = URL.decodeParam(text);

        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok(list);
    }
}
