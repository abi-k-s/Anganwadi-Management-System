package com.anganwadi.service;

import com.anganwadi.model.Users;

public interface UserService {
    Users findByUsername(String username);
}
