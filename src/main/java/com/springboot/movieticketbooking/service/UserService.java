package com.springboot.movieticketbooking.service;

import com.springboot.movieticketbooking.dto.UserDto;
import com.springboot.movieticketbooking.model.User;
import com.springboot.movieticketbooking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto createUser(UserDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("User already exists with email: " + request.getEmail());
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());

        User saved = userRepository.save(user);

        return new UserDto(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getPhone()
        );
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPhone()
                ))
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone()
        );
    }
}

