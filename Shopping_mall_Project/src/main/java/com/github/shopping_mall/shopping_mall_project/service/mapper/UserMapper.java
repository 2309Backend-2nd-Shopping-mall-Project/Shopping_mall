package com.github.shopping_mall.shopping_mall_project.service.mapper;

import com.github.shopping_mall.shopping_mall_project.repository.users.User;
import com.github.shopping_mall.shopping_mall_project.web.dto.auth.SignUp;
import com.github.shopping_mall.shopping_mall_project.web.dto.auth.SignUpResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "createDate", expression = "java(java.time.LocalDateTime.now())")
    User signUpRequestToUserEntity(SignUp signUpRequest);

    SignUpResponse userEntityToSignUpResponse(User user);
}
