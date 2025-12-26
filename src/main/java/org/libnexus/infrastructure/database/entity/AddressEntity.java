package org.libnexus.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(of = {"city", "street", "number", "postCode"})
@EqualsAndHashCode(of = "addressId")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false, unique = true)
    private Integer addressId;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "post_code", nullable = false)
    private String postCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
    @Builder.Default
    private Set<UserEntity> users = new HashSet<>();
}
