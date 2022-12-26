package com.getliner.linerhighlight.highlight.dto;

import lombok.Getter;

@Getter
public class HighlightResponseDto {
    private long highlightId;

    private long userId;

    private long pageId;

    private String colorHex;

    private String text;
}
