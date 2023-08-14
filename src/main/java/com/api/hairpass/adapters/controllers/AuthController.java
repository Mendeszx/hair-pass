package com.api.hairpass.adapters.controllers;

import com.api.hairpass.adapters.controllers.dtos.request.LoginRequest;
import com.api.hairpass.adapters.controllers.dtos.response.LoginResponse;
import com.api.hairpass.domain.useCases.auth.AuthUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    AuthUseCase authUseCase;

    @PostMapping("/login")
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return authUseCase.login(loginRequest);
    }
}
