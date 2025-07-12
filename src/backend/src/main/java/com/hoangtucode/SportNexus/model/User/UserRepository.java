package com.hoangtucode.SportNexus.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for {@link User} entity.
 * <p>
 * Extends {@link JpaRepository} to provide standard CRUD operations, as well as
 * custom query methods for user-specific lookups such as finding by username, phone number,
 * verification status, and reputation points.
 * <p>
 * This interface is a central point for database access related to users in the application.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find user by username
     *
     * @param username username to search for
     * <p>
     * @return Optional<User> The user if found, empty otherwise
     */
    Optional<User> findByUsername(String username);

    /**
     * Find user by phone number
     *
     * @param phoneNumber phone number to search for
     * <p>
     * @return Optional<User> The user if found, empty otherwise
     */
    Optional<User> findByPhoneNumber(String phoneNumber);

    /**
     * Find user by username or phone number
     *
     * @param identifier username or phone number to search for
     * <p>
     * @return Optional<User> The user if found, empty otherwise
     */
    @Query("SELECT u FROM User u WHERE u.username = :identifier OR u.phoneNumber = :identifier")
    Optional<User> findByUsernameOrPhoneNumber(@Param("identifier") String identifier);

    /**
     * Check if a user exists by username
     *
     * @param username username to check
     * <p>
     * @return boolean True if the user exists, false otherwise
     */
    boolean existsByUsername(String username);

    /**
     * Check if a user exists by phone number
     *
     * @param phoneNumber phone number to check
     * <p>
     * @return boolean True if the user exists, false otherwise
     */
    boolean existsByPhoneNumber(String phoneNumber);

    /**
     * Find all users with a specific verification status
     *
     * @param isVerified verification status to filter by
     * <p>
     * @return List<User> List of users with the specified verification status
     */
    List<User> findByIsVerified(Boolean isVerified);

    /**
     * Find all users with a minimum number of reputation points
     *
     * @param minReputation minimum reputation points to filter by
     * <p>
     * @return List<User> List of users with at least the specified reputation points
     */
    @Query("SELECT u FROM User u WHERE u.reputationPoints >= :minReputation")
    List<User> findUsersWithMinReputation(@Param("minReputation") Integer minReputation);
}