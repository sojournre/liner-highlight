package com.getliner.linerhighlight.highlight.entity;

import com.getliner.linerhighlight.audit.Auditable;
import com.getliner.linerhighlight.page.entity.Page;
import com.getliner.linerhighlight.theme.entity.ThemeColor;
import com.getliner.linerhighlight.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Highlight extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long highlightId;

    @Column(length = 6000, nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "PAGE_ID")
    private Page page;

    @ManyToOne
    @JoinColumn(name = "THEME_COLOR_ID")
    private ThemeColor themeColor;
}
