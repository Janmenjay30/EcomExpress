package com.ecom.express.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecom.express.dto.UserRequestDTO;
import com.ecom.express.dto.UserResponseDTO;
import com.ecom.express.entity.User;
import com.ecom.express.repository.UserRepository;
import com.ecom.express.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Convert entity to ResponseDTO
    private UserResponseDTO mapToResponseDTO(User user){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

    // convert RequestDTO to entity
    private User mapToEntity(UserRequestDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole("USER");
        return user;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto){
        User user = mapToEntity(dto);
        User savedUser = userRepository.save(user);
        return mapToResponseDTO(savedUser);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

}
