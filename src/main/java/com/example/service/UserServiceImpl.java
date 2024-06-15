package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        User saveduser = userRepository.save(user);
        return saveduser;
    }

    @Override
    public User updateUser(User user, Long userId) {

        User user1 = userRepository.findById(userId).get();
        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user.getAbout());

        User updatedUser = userRepository.save(user1);
        return updatedUser;
    }

    @Override
    public User getsingleUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Resource not found on server!!" + userId));
        return user;
            /* Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return user.get();
        }else {
            throw new Exception("Resource not found on server!! "+user);
        }
    }*/
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allusers = userRepository.findAll();
        return allusers;
    }

    @Override
    public void deleteUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Resource not found on server!!" + userId));

        userRepository.delete(user);
    }

}



