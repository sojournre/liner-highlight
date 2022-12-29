package com.getliner.linerhighlight.theme.entity;

import com.getliner.linerhighlight.audit.Auditable;
import com.getliner.linerhighlight.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Theme extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long themeId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "theme", cascade = CascadeType.PERSIST)
    private List<ThemeColor> themeColors = new ArrayList<>();
}
