package com.getliner.linerhighlight.user.mapper;

import com.getliner.linerhighlight.user.dto.UserPostDto;
import com.getliner.linerhighlight.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userPostDtoToUser(UserPostDto userPostDto);
}
