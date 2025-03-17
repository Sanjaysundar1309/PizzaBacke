package com.example.demo.user;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

	@Override
	public User authenticateUser(String email, String password) {
		
		        Optional<User> user = userRepository.findByEmail(email);
		        if (user.isEmpty()) {
		            throw new RuntimeException("User not found");
		        }
		        if (!user.get().getPassword().equals(password)) {
		            throw new RuntimeException("Invalid credentials");
		        }
		        return user.get();
		    }
		

	}
