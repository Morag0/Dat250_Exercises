package Morten.Aagotnes.demo.controllers;

import Morten.Aagotnes.demo.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserController {

    private final List<User> users = new ArrayList<>();


    @PostMapping
    public User createUser(@RequestBody User user) {
        users.add(user);
        return user;
    }

    @GetMapping
    public List<User> listUsers() {
        return users;
    }


    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }



}