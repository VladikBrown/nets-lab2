package com.vladbrown.netslabs.lab2.core.service.impl;

import com.vladbrown.netslabs.lab2.core.domain.entity.User;
import com.vladbrown.netslabs.lab2.core.domain.repository.UserRepository;
import com.vladbrown.netslabs.lab2.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return userRepository.findByUserName(user.getUserName()).get();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserName(username).get();
    }
}
