package com.getliner.linerhighlight.color.entity;

import com.getliner.linerhighlight.audit.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Color extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colorId;

    @Column(nullable = false)
    private String colorHex;
}
