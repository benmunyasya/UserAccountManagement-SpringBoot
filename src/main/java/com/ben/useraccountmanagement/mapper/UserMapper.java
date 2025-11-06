package com.ben.useraccountmanagement.mapper;

import com.ben.useraccountmanagement.dto.UserRequestDto;
import com.ben.useraccountmanagement.dto.UserResponseDto;
import com.ben.useraccountmanagement.entity.User;

public class UserMapper {

    public static User toEntity(UserRequestDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        return user;
    }

    public static UserResponseDto toResponse(User entity) {
        UserResponseDto resp = new UserResponseDto();
        resp.setId(entity.getId());
        resp.setUsername(entity.getUsername());
        resp.setEmail(entity.getEmail());
        resp.setPhone(entity.getPhone());
        return resp;
    }
}
