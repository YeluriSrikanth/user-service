package com.user.userservice.controller;

import com.user.userservice.dto.UserDto;
import com.user.userservice.entity.User;
import com.user.userservice.exception.UserNotFoundException;
import com.user.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        userService.saveuser(user);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getAadhar(@PathVariable int userId) throws UserNotFoundException {
        return ResponseEntity.ok(userService.findUser(userId)
                .orElseThrow(() -> new UserNotFoundException("user not found", "aaaaaaaaaa", "vvvvvvvvvvvv")));

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());

    }
    @PutMapping("/{userId}/{amount}")
    public User updateUserBalance(@PathVariable int userId, @PathVariable double amount) {
        return userService.updateAccountStatus(userId, amount);
    }


}
