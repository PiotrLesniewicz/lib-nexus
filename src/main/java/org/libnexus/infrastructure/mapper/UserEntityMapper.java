package org.libnexus.infrastructure.mapper;

import org.libnexus.domain.model.User;
import org.libnexus.infrastructure.database.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = AddressEntityMapper.class, unmappedSourcePolicy = ReportingPolicy.WARN)
public interface UserEntityMapper {

    UserEntity mapToEntity(User user);

    User mapFromEntity(UserEntity userEntity);
}
