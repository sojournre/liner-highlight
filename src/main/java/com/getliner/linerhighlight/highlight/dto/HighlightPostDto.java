package com.getliner.linerhighlight.highlight.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
public class HighlightPostDto {
    @Positive
    private long userId;

    @NotBlank
    private String pageUrl;

    @NotBlank
    private String colorHex;

    @NotBlank
    private String text;
}
