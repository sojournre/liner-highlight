package com.getliner.linerhighlight.user.service;

import com.getliner.linerhighlight.exception.BusinessLogicException;
import com.getliner.linerhighlight.exception.ExceptionCode;
import com.getliner.linerhighlight.theme.service.ThemeService;
import com.getliner.linerhighlight.user.entity.User;
import com.getliner.linerhighlight.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ThemeService themeService;

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public User findVerifiedUser(long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        return optionalUser.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
    }
}
