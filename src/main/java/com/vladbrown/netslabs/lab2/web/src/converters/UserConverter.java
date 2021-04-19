package com.vladbrown.netslabs.lab2.web.src.converters;

import com.vladbrown.netslabs.lab2.core.domain.entity.User;
import com.vladbrown.netslabs.lab2.web.src.dto.UserData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserConverter implements Converter<User, UserData> {


    @Override
    public UserData convert(User user) {
        return null;
    }

    @Override
    public void convert(User user, UserData userData) {

    }

    @Override
    public List<UserData> convertAll(User user) {
        return null;
    }
}
