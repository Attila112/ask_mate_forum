package com.codecool.askmateoop.controller;

import com.codecool.askmateoop.controller.dto.userDTO.LogedInUserDTO;
import com.codecool.askmateoop.controller.dto.userDTO.NewUserDTO;
import com.codecool.askmateoop.controller.dto.userDTO.UserDTO;
import com.codecool.askmateoop.model.User;
import com.codecool.askmateoop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public int createUser(@RequestBody NewUserDTO newUserDTO) {
        return userService.saveUser(newUserDTO);
    }

    @PatchMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody NewUserDTO userDTO) {
        userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LogedInUserDTO userData) {
        return userService.login((userData));
    }

}
