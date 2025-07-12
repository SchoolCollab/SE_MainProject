package com.hoangtucode.SportNexus.model.User;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

/**
 * User entity representing a user in the system.
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$",
        message = "Username can only contain letters, numbers, and underscores")
    private String username;

    @Column(name = "phone_number", unique = true, nullable = false, length = 20)
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid phone number format")
    private String phoneNumber;

    @Column(name = "password_hash", nullable = false)
    @NotBlank(message = "Password is required")
    private String passwordHash;

    @Column(name = "full_name", nullable = false, length = 100, columnDefinition = "NVARCHAR(100)")
    @NotBlank(message = "Full name is required")
    @Size(min = 2, max = 100, message = "Full name must be between 2 and 100 characters")
    private String fullName;

    @Column(name = "reputation_points", nullable = false)
    @Min(value = 0, message = "Reputation points cannot be negative")
    @Builder.Default
    private Integer reputationPoints = 80;

    @Column(name = "is_verified", nullable = false)
    @Builder.Default
    private Boolean isVerified = false;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // Helper methods

    /**
     * Verifies the user, setting isVerified to true and initializing reputation points.
     */
    public void verify() {
        this.isVerified = true;
        this.reputationPoints = 100;
    }

    /**
     * Checks if the user is verified.
     *
     * @return boolean True if the user is verified, False otherwise
     */
    public boolean isVerified() {
        return this.isVerified != null && this.isVerified;
    }

    /**
     * Adds reputation points to the user.
     *
     * @param points the number of points to add
     */
    public void addReputationPoints(int points) {
        this.reputationPoints += points;
    }

    /**
     * Deducts reputation points from the user.
     *
     * @param points the number of points to deduct
     */
    public void deductReputationPoints(int points) {
        this.reputationPoints = Math.max(0, this.reputationPoints - points);
    }
}