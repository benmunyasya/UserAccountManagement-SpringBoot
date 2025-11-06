package com.ben.useraccountmanagement.service;

import com.ben.useraccountmanagement.dto.UserRequestDto;
import com.ben.useraccountmanagement.dto.UserResponseDto;
import com.ben.useraccountmanagement.entity.User;
import com.ben.useraccountmanagement.mapper.UserMapper;
import com.ben.useraccountmanagement.repository.UserRepository;
import com.ben.useraccountmanagement.exception.EmailAlreadyExistsException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<UserResponseDto> findAll() {
        return repo.findAll().stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    public UserResponseDto create(UserRequestDto dto) {
     
        User saved = repo.save(UserMapper.toEntity(dto));
        return UserMapper.toResponse(saved);
    }

    public UserResponseDto findById(Long id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toResponse(user);
    }

    public UserResponseDto update(Long id, UserRequestDto dto) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        return UserMapper.toResponse(repo.save(user));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
