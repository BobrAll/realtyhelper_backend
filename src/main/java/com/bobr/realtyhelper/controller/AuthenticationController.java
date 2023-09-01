package com.bobr.realtyhelper.controller;

import com.bobr.realtyhelper.auth.AuthenticationRequest;
import com.bobr.realtyhelper.auth.AuthenticationResponse;
import com.bobr.realtyhelper.auth.AuthenticationService;
import com.bobr.realtyhelper.auth.RegisterRequest;
import com.bobr.realtyhelper.user.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request,
                                                           HttpServletResponse response) {
        if (userService.isUserExist(request.getEmail()))
            return ResponseEntity.status(403).build();
        else
            return ResponseEntity.ok(authService.register(request, response));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
