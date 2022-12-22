package com.getliner.linerhighlight.user.controller;

import com.getliner.linerhighlight.user.dto.UserPostDto;
import com.getliner.linerhighlight.user.entity.User;
import com.getliner.linerhighlight.user.mapper.UserMapper;
import com.getliner.linerhighlight.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/users")
@Validated
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    @PostMapping
    public ResponseEntity postUser(@Valid @RequestBody UserPostDto userPostDto) {
        User user = mapper.userPostDtoToUser(userPostDto);
        userService.createUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
