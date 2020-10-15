package com.codingsy.demo.service.impl;

import com.codingsy.demo.service.IUserService;
import com.codingsy.demo.mapper.UserMapper;
import com.codingsy.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userDao;

    @Override
    public List<User> getUser() {
        return userDao.getByIds(Arrays.asList(1L));
    }
}
