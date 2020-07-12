package com.shoban.controllers;

import com.shoban.repository.User;
import com.shoban.exception.DataNotFoundException;
import com.shoban.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/exception")
@RestController
public class ExceptionDemoController {
    @Autowired
    private UserRepository repository;
    @PostMapping(value = "/users/save")
    public void postUserRequest(@RequestBody User user){
        if(user == null){
            throw new RuntimeException();
        }
        repository.save(user);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> users(@PathVariable String userId) throws DataNotFoundException {
        Optional<User> user = repository.findById(Long.parseLong(userId));
        if(user.get() == null){
            throw new DataNotFoundException();
        }
        return ResponseEntity.of(user);
    }
}
