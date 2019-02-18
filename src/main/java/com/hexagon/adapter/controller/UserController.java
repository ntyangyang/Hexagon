package com.hexagon.adapter.controller;

import com.hexagon.core.domain.User;
import com.hexagon.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Eason
 * @createTime 2019-02-18 下午 11:03
 * @description
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Object> create(@RequestParam String username,
                                         @RequestParam String age) {
        User user = userService.registerUser(new User(null, username, age));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> get(@PathVariable("userId") Integer userId) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    @PatchMapping("/user/{userId}")
    public ResponseEntity<Object> update(@PathVariable("userId") Integer userId,
                                         @RequestParam String username,
                                         @RequestParam String age) {
        User user = userService.updateUser(new User(userId, username, age));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<Object> all() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

}
