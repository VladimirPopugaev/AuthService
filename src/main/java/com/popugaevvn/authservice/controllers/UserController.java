package com.popugaevvn.authservice.controllers;

import com.popugaevvn.authservice.models.Role;
import com.popugaevvn.authservice.models.User;
import com.popugaevvn.authservice.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public List<User> index() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return users;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping()
    public void saveUser() {
        User savedUser = new User(1, "test login 111", "first name 111", Role.USER);
        User savedUser2 = new User(2, "test login 222", "first name 222", Role.USER);
        User savedUser3 = new User(3, "test login 333", "first name 333", Role.ADMIN);
        userRepository.saveAll(List.of(savedUser, savedUser2, savedUser3));
    }

}
