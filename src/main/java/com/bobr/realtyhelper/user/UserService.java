package com.bobr.realtyhelper.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public boolean isUserExist(String email) {
        return !repository.findByEmail(email).isEmpty();
    }
}
