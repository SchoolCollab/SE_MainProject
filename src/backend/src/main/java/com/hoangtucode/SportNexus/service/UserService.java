package com.hoangtucode.SportNexus.service;

import com.hoangtucode.SportNexus.model.User.*;

import org.springframework.stereotype.Service;
import org.springframework.data.util.Streamable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Service class for managing user-related operations.
 * <p>
 * This class provides methods to find users by username or phone number,
 * check user existence, and save or delete users.
 * </p>
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Find all users.
     *
     * @return List<User> A list of all users
     */
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        // Convert Iterable to List of user
        Streamable.of(userRepository.findAll())
        .forEach(users::add);

        return users;
    }

    /**
     * Find a user by username.
     *
     * @param username The username to search for
     * <p>
     * @return Optional<User> The user if found, empty otherwise
     */
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Check if a user exists by username.
     *
     * @param username The username to check
     * <p>
     * @return boolean True if the user exists, false otherwise
     */
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    /**
     * Find a user by phone number.
     *
     * @param phoneNumber The phone number to search for
     * <p>
     * @return Optional<User> The user if found, empty otherwise
     */
    public Optional<User> findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    /**
     * Find a user by username or phone number.
     *
     * @param identifier The username or phone number to search for
     * <p>
     * @return Optional<User> The user if found, empty otherwise
     */
    public Optional<User> findByUsernameOrPhoneNumber(String identifier) {
        return userRepository.findByUsernameOrPhoneNumber(identifier);
    }

    /**
     * Save a user.
     *
     * @param user The user to save
     * <p>
     * @return User The saved user entity
     */
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     * Delete a user
     *
     * @param user The user to delete
     */
    public void delete (User user) {
        userRepository.delete(user);
    }

    /**
     * Delete a user by their ID.
     *
     * @param id The ID of the user to delete
     */
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
