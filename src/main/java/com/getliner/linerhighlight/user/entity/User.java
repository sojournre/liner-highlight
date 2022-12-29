package com.getliner.linerhighlight.user.entity;

import com.getliner.linerhighlight.audit.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private Long themeId;

    private String email;

    private String password;

}
