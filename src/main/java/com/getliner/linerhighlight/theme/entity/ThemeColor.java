package com.getliner.linerhighlight.theme.entity;

import com.getliner.linerhighlight.audit.Auditable;
import com.getliner.linerhighlight.color.entity.Color;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ThemeColor extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ThemeColorId;

    @Column(nullable = false)
    private int sequence;

    @ManyToOne
    @JoinColumn(name = "THEME_ID")
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "COLOR_ID")
    private Color color;
}
