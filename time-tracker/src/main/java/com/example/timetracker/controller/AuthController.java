package com.example.timetracker.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import com.example.timetracker.dto.AuthRequest;
import com.example.timetracker.dto.AuthResponse;
import com.example.timetracker.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.timetracker.entity.User;
import com.example.timetracker.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.timetracker.entity.Role;

@Slf4j
@Tag(
        name = "Authentication",
        description = "login and registration"
)
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Operation(summary = "Register user")
    @PostMapping("/register")
public AuthResponse register(
        @RequestBody AuthRequest request
) {
        log.info("Registering user: {}",
                request.getEmail()
        );

    User user = new User();

    user.setEmail(request.getEmail());

    user.setPassword(
            passwordEncoder.encode(
                    request.getPassword()
            )
    );

    user.setRole(Role.USER);

    userRepository.save(user);

    String token = jwtService.generateToken(
            user.getEmail()
    );

    return new AuthResponse(token);
}

    @Operation(summary = "Login user")
    @PostMapping("/login")
public AuthResponse login(
        @RequestBody AuthRequest request
) {

        log.info("User login: {}",
                request.getEmail()
        );

    User user = userRepository
            .findByEmail(request.getEmail())
            .orElseThrow();

    boolean matches =
            passwordEncoder.matches(
                    request.getPassword(),
                    user.getPassword()
            );

    if (!matches) {
        throw new RuntimeException(
                "Invalid password"
        );
    }

    String token = jwtService.generateToken(
            user.getEmail()
    );

    return new AuthResponse(token);
}
}
