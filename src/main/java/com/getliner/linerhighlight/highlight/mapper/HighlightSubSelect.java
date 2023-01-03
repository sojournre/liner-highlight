package com.getliner.linerhighlight.highlight.mapper;

import com.getliner.linerhighlight.page.entity.Webpage;
import com.getliner.linerhighlight.theme.entity.ThemeColor;
import com.getliner.linerhighlight.user.entity.User;
import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Subselect(
        "select " +
                "row_number() over (partition by USER_ID, PAGE_ID order by UPDATED_AT desc) as ROW_NUM, " +
//                "h.HIGHLIGHT_ID, " +
//                "h.USER_ID, " +
//                "h.PAGE_ID, " +
//                "h.TEXT, " +
//                "h.UPDATED_AT " +
                "h.*" +
                "from HIGHLIGHT h "
)
@Immutable
@Synchronize("HIGHLIGHT")
@Getter
public class HighlightSubSelect {

    private Long rowNum;

    @Id
    @GeneratedValue
    private Long highlightId;

//    private Long userId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

//    private Long pageId;

    @ManyToOne
    @JoinColumn(name = "PAGE_ID")
    private Webpage webpage;

    private String text;

    @ManyToOne
    @JoinColumn(name = "THEME_COLOR_ID")
    private ThemeColor themeColor;

    private LocalDateTime updatedAt;

}
