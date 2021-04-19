package com.vladbrown.netslabs.lab2.core.service;

import com.vladbrown.netslabs.lab2.core.domain.entity.User;

public interface UserService extends PlainDataService<User, Long> {

    User findByUsername(String username);
}
