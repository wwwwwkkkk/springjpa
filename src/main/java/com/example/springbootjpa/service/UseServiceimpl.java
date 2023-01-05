package com.example.springbootjpa.service;

import com.example.springbootjpa.entity.User;
import com.example.springbootjpa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
public class UseServiceimpl implements UseService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addandupdate() {

        User user = new User();
        user.setPassword("123");
        user.setRegdate(new Date());
        user.setUsername("凯-事务1+加钱");
        userRepository.save(user);

        User usertwo = new User();
        usertwo.setPassword("1233123222222222");
        usertwo.setRegdate(new Date());
        usertwo.setUsername("凯-事务2-减钱");
        userRepository.save(usertwo);
        return null;
    }
}
