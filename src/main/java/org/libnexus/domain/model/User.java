package org.libnexus.domain.model;

import lombok.*;

import java.time.OffsetDateTime;

@With
@Value
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"address"})
public class User {

    @EqualsAndHashCode.Include
    Integer userId;
    String name;
    String surname;
    String email;
    String password;
    String phoneNumber;
    Role role;
    OffsetDateTime membershipDate;
    OffsetDateTime hireDate;
    boolean active;
    Address address;

    public User asRegularUser() {
        return this.toBuilder()
                .role(Role.USER)
                .hireDate(null)
                .build();
    }

    public User promoteToLibrarian(OffsetDateTime hireDate) {
        if (this.role == Role.LIBRARIAN) {
            return this;
        }
        return this.toBuilder()
                .role(Role.LIBRARIAN)
                .hireDate(hireDate)
                .build();
    }
}
