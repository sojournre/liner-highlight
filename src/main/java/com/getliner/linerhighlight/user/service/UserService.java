package com.getliner.linerhighlight.user.service;

import com.getliner.linerhighlight.user.entity.User;
import com.getliner.linerhighlight.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
