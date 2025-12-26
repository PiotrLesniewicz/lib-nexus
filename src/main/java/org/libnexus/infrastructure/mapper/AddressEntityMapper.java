package org.libnexus.infrastructure.mapper;

import org.libnexus.domain.model.Address;
import org.libnexus.domain.model.User;
import org.libnexus.infrastructure.database.entity.AddressEntity;
import org.libnexus.infrastructure.database.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.WARN)
public interface AddressEntityMapper {

    AddressEntity mapToEntity(Address address);

    @Mapping(target = "users", source = "users")
    Address mapFromEntity(AddressEntity addressEntity);

    default Set<User> mapUsers(Set<UserEntity> entities) {
        return entities.stream()
                .map(entity -> User.builder()
                        .userId(entity.getUserId())
                        .name(entity.getName())
                        .surname(entity.getSurname())
                        .email(entity.getEmail())
                        .password(entity.getPassword())
                        .phoneNumber(entity.getPhoneNumber())
                        .membershipDate(entity.getMembershipDate())
                        .hireDate(entity.getHireDate())
                        .isActive(entity.isActive())
                        .role(entity.getRole())
                        .build())
                .collect(Collectors.toSet());
    }

}
