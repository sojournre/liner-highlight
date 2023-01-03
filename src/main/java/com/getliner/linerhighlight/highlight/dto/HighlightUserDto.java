package com.getliner.linerhighlight.highlight.dto;

import lombok.Getter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Positive;

@Getter
public class HighlightUserDto {
    @Positive
    private long userId;
}
