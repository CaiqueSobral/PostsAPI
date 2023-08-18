package com.postsapi.posts.services;

import com.postsapi.posts.domain.User;
import com.postsapi.posts.domain.dto.UserDTO;
import com.postsapi.posts.repository.UserRepository;
import com.postsapi.posts.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    public List<User> findAll(){
        return userRepo.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepo.findById(id);

        if(user.isEmpty()){
            throw new ObjectNotFoundException("Object not found");
        }

        return user.get();
    }

    public User insert(User obj){
        return userRepo.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
