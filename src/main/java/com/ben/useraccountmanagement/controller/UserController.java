package com.ben.useraccountmanagement.controller;

import com.ben.useraccountmanagement.dto.UserRequestDto;
import com.ben.useraccountmanagement.dto.UserResponseDto;
import com.ben.useraccountmanagement.response.ApiResponse;
import com.ben.useraccountmanagement.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // GET /users → 200 OK
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> getAllUsers(HttpServletRequest request) {
        List<UserResponseDto> users = service.findAll();
        ApiResponse<List<UserResponseDto>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                users,
                "Users retrieved successfully",
                request.getRequestURI()
        );
        return ResponseEntity.ok(response);
    }

    // GET /users/{id} → 200 OK (or 404 handled globally)
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUserById(@PathVariable Long id,
                                                                    HttpServletRequest request) {
        UserResponseDto user = service.findById(id);
        ApiResponse<UserResponseDto> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                user,
                "User retrieved successfully",
                request.getRequestURI()
        );
        return ResponseEntity.ok(response);
    }

    // POST /users → 201 Created
    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(@Valid @RequestBody UserRequestDto dto,
                                                                   HttpServletRequest request) {
        UserResponseDto created = service.create(dto);
        ApiResponse<UserResponseDto> response = new ApiResponse<>(
                HttpStatus.CREATED.value(),
                created,
                "User created successfully",
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // PUT /users/{id} → 200 OK
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> updateUser(@PathVariable Long id,
                                                                   @Valid @RequestBody UserRequestDto dto,
                                                                   HttpServletRequest request) {
        UserResponseDto updated = service.update(id, dto);
        ApiResponse<UserResponseDto> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                updated,
                "User updated successfully",
                request.getRequestURI()
        );
        return ResponseEntity.ok(response);
    }

    // DELETE /users/{id} → 204 No Content
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id,
                                                        HttpServletRequest request) {
        service.delete(id);
        ApiResponse<Void> response = new ApiResponse<>(
                HttpStatus.NO_CONTENT.value(),
                null,
                "User deleted successfully",
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
