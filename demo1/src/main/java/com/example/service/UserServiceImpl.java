package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        return null;
    }

    @Override
    public List<User> getallUsers() {
        return List.of();
    }

    @Override
    public void deleteUser(Long UserId) {

    }
}
