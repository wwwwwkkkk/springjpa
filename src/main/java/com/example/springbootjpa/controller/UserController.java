package com.example.springbootjpa.controller;


import com.example.springbootjpa.entity.User;
import com.example.springbootjpa.repository.UserRepository;
import com.example.springbootjpa.service.UseService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j //    日志
//try{
//        }catch 抛异常
public class UserController {
    @Autowired
    private UserRepository userRepository;
@Autowired
private UseService useService;
    //查找所有User对象
    @GetMapping("/findall")
    public List<User> findall() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    //添加user对象
    @PostMapping("/add")
    public void add(@RequestBody User user) {
        try {

            userRepository.save(user);
            String addandupdate = useService.addandupdate();
        } catch (Exception e) {
        }
    }

    //删除user对象
    @GetMapping("delete")
    public void delete(@RequestParam Long id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/update")
    public void update(@RequestBody User user) {
        try {

            userRepository.saveAndFlush(user);
        } catch (Exception e) {
            log.error("异常:{}", e);
        }
    }
}
