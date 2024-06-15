package com.example.controller;

import com.example.model.User;
import com.example.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

   @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
       User savedUser = userServiceI.createUser(user);
       return new ResponseEntity<User>(savedUser, HttpStatus.OK);
    }
   @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
       List<User> allUsers = userServiceI.getAllUsers();
       return  new ResponseEntity<>(allUsers,HttpStatus.OK);
   }
   @GetMapping("/users/{userId}")
    public ResponseEntity<User> getsingleUser(@PathVariable Long userId) throws Exception {
       User user = userServiceI.getsingleUser(userId);
       return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long userId){
        User updatedUsers = userServiceI.updateUser(user, userId);
        return  new ResponseEntity<>( updatedUsers, HttpStatus.CREATED);
    }
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String>deleteUser(@PathVariable Long userId){
       userServiceI.deleteUser(userId);
        return new ResponseEntity<>("Resoure Delete sucessfully!!",HttpStatus.OK);

    }
}
