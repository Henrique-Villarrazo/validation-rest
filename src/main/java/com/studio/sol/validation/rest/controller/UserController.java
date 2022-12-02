package com.studio.sol.validation.rest.controller;

import com.studio.sol.validation.rest.dto.SignupRequest;
import com.studio.sol.validation.rest.dto.SignupResponse;
import com.studio.sol.validation.rest.model.User;
import com.studio.sol.validation.rest.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("verify")
public class UserController {

    private final UsuarioRepository repository;

    public UserController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<SignupResponse> signUp(@RequestBody @Valid SignupRequest request) {

        SignupResponse response = SignupResponse.builder()
                .user(repository.save(new User(request.getEmail(), request.getPassword())))
                .message("Sign Up Complete!")
                .timestamp(Instant.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SignupResponse handlePasswordValidationException(MethodArgumentNotValidException e) {

        //Returning password error message as a response.
        return SignupResponse.builder()
                .message(String.join(",", e.getBindingResult().getFieldError().getDefaultMessage()))
                .timestamp(Instant.now())
                .build();

    }

}