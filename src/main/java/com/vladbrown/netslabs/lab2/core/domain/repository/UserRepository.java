package com.vladbrown.netslabs.lab2.core.domain.repository;

import com.vladbrown.netslabs.lab2.core.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserName(String userName);
}
