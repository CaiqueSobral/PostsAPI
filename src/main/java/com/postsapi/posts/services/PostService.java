package com.postsapi.posts.services;

import com.postsapi.posts.domain.Post;
import com.postsapi.posts.domain.User;
import com.postsapi.posts.domain.dto.UserDTO;
import com.postsapi.posts.repository.PostRepository;
import com.postsapi.posts.repository.UserRepository;
import com.postsapi.posts.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepo;

    public Post findById(String id){
        Optional<Post> post = postRepo.findById(id);

        if(post.isEmpty()){
            throw new ObjectNotFoundException("Object not found");
        }

        return post.get();
    }

    public List<Post> findByTitle(String txt){
        return postRepo.findByTitleContainingIgnoreCase(txt);
    }
}
