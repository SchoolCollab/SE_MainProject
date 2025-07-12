package com.hoangtucode.SportNexus.model.PhoneVerification;

import com.hoangtucode.SportNexus.model.User.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for {@link PhoneVerification} entity.
 * <p>
 * Provides methods to manage phone verification codes, including finding active verifications,
 * checking verification attempts, and deleting expired codes.
 */
@Repository
public interface PhoneVerificationRepository extends JpaRepository<PhoneVerification, Long> {

    /**
     * Find active phone verification for a user.
     *
     * @param user The user for whom to find the active verification
     * @param now The current time to check against expiration
     * <p>
     * @return Optional<PhoneVerification> The active verification if found, empty otherwise
     */
    @Query("SELECT pv FROM PhoneVerification pv WHERE pv.user = :user AND pv.isVerified = false AND pv.expiresAt > :now ORDER BY pv.createdAt DESC")
    Optional<PhoneVerification> findActiveVerificationByUser(@Param("user") User user,
        @Param("now") LocalDateTime now);

    /**
     * Find active phone verification by phone number and code.
     *
     * @param phoneNumber The phone number to search for
     * @param code The verification code to search for
     * @param now The current time to check against expiration
     * <p>
     * @return Optional<PhoneVerification> The active verification if found, empty otherwise
     */
    @Query("SELECT pv FROM PhoneVerification pv WHERE pv.phoneNumber = :phoneNumber AND pv.verificationCode = :code AND pv.isVerified = false AND pv.expiresAt > :now")
    Optional<PhoneVerification> findByPhoneNumberAndCode(@Param("phoneNumber") String phoneNumber,
        @Param("code") String code, @Param("now") LocalDateTime now);

    /**
     * Find all phone verifications for a user ordered by creation date.
     *
     * @param user The user for whom to find verifications
     * <p>
     * @return List<PhoneVerification> List of verifications for the user
     */
    List<PhoneVerification> findByPhoneNumberOrderByCreatedAtDesc(String phoneNumber);

    /**
     * Find all expired phone verifications.
     *
     * @param dateTime The date and time to check against expiration
     * <p>
     * @return List<PhoneVerification> List of expired verifications
     */
    List<PhoneVerification> findByExpiresAtBefore(LocalDateTime dateTime);


    /**
     * Delete all expired phone verification codes.
     *
     * @param dateTime The date and time to check against expiration
     */
    @Modifying
    @Transactional
    @Query("DELETE FROM PhoneVerification pv WHERE pv.expiresAt < :dateTime")
    void deleteExpiredCodes(@Param("dateTime") LocalDateTime dateTime);

    /**
     * Count verification attempts for a user in the last hour.
     *
     * @param user The user for whom to count attempts
     * @param since The time to check against (1 hour ago)
     * <p>
     * @return Long The number of verification attempts in the last hour
     */
    @Query("SELECT COUNT(pv) FROM PhoneVerification pv WHERE pv.user = :user AND pv.createdAt > :since")
    Long countRecentAttemptsByUser(@Param("user") User user, @Param("since") LocalDateTime since);

    /**
     * Count verification attempts for a phone number in the last hour.
     *
     * @param phoneNumber The phone number to check
     * @param since The time to check against (1 hour ago)
     * <p>
     * @return Long The number of verification attempts in the last hour
     */
    @Query("SELECT COUNT(pv) FROM PhoneVerification pv WHERE pv.phoneNumber = :phoneNumber AND pv.createdAt > :since")
    Long countRecentAttemptsByPhoneNumber(@Param("phoneNumber") String phoneNumber,
        @Param("since") LocalDateTime since);
}