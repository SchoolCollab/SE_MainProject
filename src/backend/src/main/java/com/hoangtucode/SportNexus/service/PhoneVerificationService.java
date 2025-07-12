package com.hoangtucode.SportNexus.service;

import com.hoangtucode.SportNexus.model.User.*;
import com.hoangtucode.SportNexus.model.PhoneVerification.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


/**
 * Service class for managing phone verification operations.
 * <p>
 * This class provides methods to interact with the phone verification repository,
 * allowing for operations such as saving, finding, and deleting phone verifications.
 * </p>
 */
@Service
public class PhoneVerificationService {

    @Autowired
    private PhoneVerificationRepository phoneVerificationRepository;

    /**
     * Find an active phone verification for a user.
     *
     * @param user The user for whom to find the active verification
     * <p>
     * @return Optional<PhoneVerification> The active verification if found, empty otherwise
     */
    public List<PhoneVerification> findAll() {
        return phoneVerificationRepository.findAll();
    }

    /**
     * Find active phone verification for a user.
     *
     * @param user The user for whom to find the active verification
     * @param now The current time to check against expiration
     * <p>
     * @return Optional<PhoneVerification> The active verification if found, empty otherwise
     */
    public Optional<PhoneVerification> findActiveVerificationByUser(User user, LocalDateTime now) {
        return phoneVerificationRepository.findActiveVerificationByUser(user, now);
    }

    /**
     * Find active phone verification by phone number and code.
     *
     * @param phoneNumber The phone number to search for
     * @param code The verification code to search for
     * @param now The current time to check against expiration
     * <p>
     * @return Optional<PhoneVerification> The active verification if found, empty otherwise
     */
    public Optional<PhoneVerification> findByPhoneNumberAndCode(String phoneNumber, String code,
        LocalDateTime now) {
        return phoneVerificationRepository.findByPhoneNumberAndCode(phoneNumber, code, now);
    }

    /**
     * Save a phone verification entity.
     *
     * @param phoneVerification The phone verification entity to save
     * <p>
     * @return PhoneVerification The saved phone verification entity
     */
    public PhoneVerification save(PhoneVerification phoneVerification) {
        return phoneVerificationRepository.save(phoneVerification);
    }

    /**
     * Delete a phone verification entity.
     *
     * @param phoneVerification The phone verification entity to delete
     */
    public void delete (PhoneVerification phoneVerification) {
        phoneVerificationRepository.delete(phoneVerification);
    }

    /**
     * Delete a phone verification by its ID.
     *
     * @param id The ID of the phone verification to delete
     */
    public void deleteById(Long id) {
        phoneVerificationRepository.deleteById(id);
    }
}
