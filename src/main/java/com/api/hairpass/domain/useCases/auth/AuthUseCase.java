package com.api.hairpass.domain.useCases.auth;

import com.api.hairpass.adapters.controllers.dtos.request.LoginRequest;
import com.api.hairpass.adapters.controllers.dtos.response.LoginResponse;
import org.springframework.http.ResponseEntity;

public interface AuthUseCase {
    ResponseEntity<LoginResponse> login(LoginRequest loginRequest);
}
