package com.getliner.linerhighlight.highlight.entity;

import com.getliner.linerhighlight.audit.Auditable;
import com.getliner.linerhighlight.page.entity.Webpage;
import com.getliner.linerhighlight.theme.entity.ThemeColor;
import com.getliner.linerhighlight.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"text", "USER_ID", "PAGE_ID", "THEME_COLOR_ID"})
})
public class Highlight extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long highlightId;

    @Column(length = 6000, nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PAGE_ID")
    private Webpage webpage;

    @ManyToOne
    @JoinColumn(name = "THEME_COLOR_ID")
    private ThemeColor themeColor;
}
