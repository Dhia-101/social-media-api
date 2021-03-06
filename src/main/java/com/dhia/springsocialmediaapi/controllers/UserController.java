package com.dhia.springsocialmediaapi.controllers;

import com.dhia.springsocialmediaapi.model.UserDTO;
import com.dhia.springsocialmediaapi.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = {"users"})
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "get all users")
    @GetMapping(value = "")
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    @PreAuthorize("hasRole('USER')")
    @ApiOperation(value = "get a specific user")
    @GetMapping(value = "/{userId}")
    public UserDTO getUser(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @ApiOperation(value = "add a user")
    @PostMapping(value = "")
    public UserDTO addUser(@RequestBody UserDTO userDto) {
        return userService.save(userDto);
    }

    @ApiOperation(value = "delete a user")
    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
    }

    @ApiOperation(value = "delete a user")
    @PutMapping(value = "/{userId}")
    public void updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        userService.update(userId, userDTO);
    }



}
