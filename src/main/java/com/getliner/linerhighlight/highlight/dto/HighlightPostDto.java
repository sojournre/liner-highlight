package com.getliner.linerhighlight.highlight.dto;

import lombok.Getter;

@Getter
public class HighlightPostDto {
    private long userId;

    private String pageUrl;

    private String colorHex;

    private String text;
}
