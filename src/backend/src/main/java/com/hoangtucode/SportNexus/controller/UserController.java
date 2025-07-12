package com.hoangtucode.SportNexus.controller;

import com.hoangtucode.SportNexus.model.User.*;
import com.hoangtucode.SportNexus.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * UserController handles user-related operations.
 * <p>
 * This controller is responsible for managing user accounts, including registration,
 * login, and profile management. It interacts with the UserService to perform these
 * operations and returns appropriate responses to the client.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Endpoint to get all users.
     * <p>
     * This method retrieves all users from the UserService.
     * It returns a list of all users in the system.
     *
     * @return List<User> A list of all users
     */
    @GetMapping("/get-all")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    /**
     * Endpoint to get a user by username.
     * <p>
     * This method retrieves a user by their username using the UserService.
     * It returns the user object if found, or an appropriate response if not found.
     *
     * @param username The username of the user to retrieve
     * <p>
     * @return Optional<User> The user object if found
     */
    @GetMapping("/get-by-username")
    public Optional<User> getUserByUsername(String username) {
        return userService.findByUsername(username);
    }

    /**
     * Endpoint to add a new user.
     * <p>
     * This method creates a new user with predefined values for testing purposes.
     * It uses the UserService to save the user and returns the created user object.
     *
     * @return User The newly created user
     */
    @PostMapping("/add-user")
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * Endpoint to delete a user by username.
     * <p>
     * This method deletes a user by their username using the UserService.
     * It returns a success message if the user is deleted, or an error message if not found.
     *
     * @param username The username of the user to delete
     */
    @PostMapping("/delete-by-username")
    public void deleteUserByUsername(@RequestBody String username) {
        Optional<User> userOptional = userService.findByUsername(username);

        if (userOptional.isPresent()) {
            userService.delete(userOptional.get());
        }
    }

}
