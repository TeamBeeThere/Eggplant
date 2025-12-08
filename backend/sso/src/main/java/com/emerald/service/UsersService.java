package com.emerald.service;

import com.emerald.model.Users;
import com.emerald.model.Login;
import com.emerald.repository.UsersRepository;
import com.emerald.repository.LoginRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsersService {

    // --- Dependencies (Fields) ---
    private final UsersRepository userRepository;
    private final LoginRepository loginRepository;

    // --- Constructor Injection ---
    /**
     * Constructor used by Spring to inject the required repository dependencies.
     */
    @Autowired
    public UsersService(UsersRepository userRepository, LoginRepository loginRepository) {
        this.userRepository = userRepository;
        this.loginRepository = loginRepository;
    }

    // Business logic methods would go here, focusing on User and Login operations...
}