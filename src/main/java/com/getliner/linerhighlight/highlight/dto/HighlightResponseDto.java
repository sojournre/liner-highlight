package com.getliner.linerhighlight.highlight.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HighlightResponseDto {
    private long highlightId;

    private long userId;

    private long pageId;

    private String colorHex;

    private String text;
}
