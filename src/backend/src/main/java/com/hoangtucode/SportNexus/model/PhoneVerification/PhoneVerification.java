package com.hoangtucode.SportNexus.model.PhoneVerification;

import com.hoangtucode.SportNexus.model.User.User;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

/**
 * Entity representing a phone verification code for a user.
 * <p>
 * This entity is used to store the phone number, verification code, expiration time,
 * and attempt count for verifying a user's phone number.
 * </p>
 */
@Entity
@Table(name = "phone_verification_codes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PhoneVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "phone_number", nullable = false, length = 20)
    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;

    @Column(name = "verification_code", nullable = false, length = 6)
    @NotBlank(message = "Verification code cannot be blank")
    @Size(min = 6, max = 6, message = "Verification code must be exactly 6 characters")
    private String verificationCode;

    @Column(name = "expires_at", nullable = false)
    @Future(message = "Expiration time must be in the future")
    private LocalDateTime expiresAt;

    @Column(name = "attempt_count", nullable = false)
    @Min(value = 0, message = "Attempt count cannot be negative")
    @Max(value = 10, message = "Attempt count cannot exceed 10")
    @Builder.Default
    private Integer attemptCount = 0;

    @Column(name = "is_verified", nullable = false)
    @Builder.Default
    private Boolean isVerified = false;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Helper methods

    /**
     * Check if the verification code is expired.
     *
     * @return boolean True if the code is expired, false otherwise
     */
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(this.expiresAt);
    }

    /**
     * Check if the verification code is valid.
     *
     * @return boolean True if the code is valid, false otherwise
     */
    public boolean canAttemptVerification() {
        return !isExpired() && !isVerified && attemptCount < 3;
    }

    /**
     * Increment the attempt count for this verification code.
     * <p>
     * This method should be called each time a verification attempt is made.
     */
    public void incrementAttemptCount() {
        this.attemptCount++;
    }

    /**
     * Mark the verification as successful.
     * <p>
     * This method should be called when the verification code is successfully verified.
     */
    public void markAsVerified() {
        this.isVerified = true;
    }
}
