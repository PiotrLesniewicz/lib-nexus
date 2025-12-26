package org.libnexus.domain.model;

import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@With
@Value
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "users")
public class Address {

    @EqualsAndHashCode.Include
    Integer addressId;
    String city;
    String street;
    String number;
    String postCode;
    @Builder.Default
    Set<User> users = new HashSet<>();

    public Address withAddedUser(User user) {
        Set<User> update = new HashSet<>(this.getUsers());
        update.add(user);
        return withUsers(update);
    }

    public Address withRemovedUser(User user) {
        Set<User> update = new HashSet<>(this.getUsers());
        update.remove(user);
        return withUsers(update);
    }

    public boolean isAddressChanged(Address update) {
        return !Objects.equals(this.getCity(),update.getCity())
                || !Objects.equals(this.getStreet(),update.getStreet())
                || !Objects.equals(this.getNumber(),update.getNumber())
                || !Objects.equals(this.getPostCode(),update.getPostCode());
    }
}
