package org.libnexus.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.libnexus.domain.model.Role;

import java.time.OffsetDateTime;

@Getter
@Setter
@ToString(of = {"name", "surname", "email"})
@EqualsAndHashCode(of = "userId")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class
UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    private Integer userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "membership_date", nullable = false, updatable = false)
    private OffsetDateTime membershipDate;

    @Column(name = "hire_date")
    private OffsetDateTime hireDate;

    @Column(name = "is_active", nullable = false)
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity address;
}
