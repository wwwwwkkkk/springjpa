package com.example.springbootjpa;

import com.example.springbootjpa.entity.User;
import com.example.springbootjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.List;


@RestController
public class UserController1 {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("aa")
    public void aa(@RequestParam Long id) {
        userRepository.deleteById(id);
    }
}
