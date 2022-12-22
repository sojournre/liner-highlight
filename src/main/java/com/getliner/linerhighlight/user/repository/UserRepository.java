package com.getliner.linerhighlight.user.repository;

import com.getliner.linerhighlight.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
