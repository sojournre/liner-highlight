package com.getliner.linerhighlight.highlight.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HighlightPageResponseDto {
    private long pageId;

    private String pageUrl;

    private List<HighlightResponseDto> highlights;
}
