package com.ecom.express.service;

import java.util.List;

import com.ecom.express.dto.UserRequestDTO;
import com.ecom.express.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO dto);
    List<UserResponseDTO> getAllUsers();
}
