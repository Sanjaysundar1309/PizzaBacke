package com.example.demo.user;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
