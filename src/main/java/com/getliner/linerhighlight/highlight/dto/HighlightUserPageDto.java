package com.getliner.linerhighlight.highlight.dto;

import lombok.Getter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Positive;

@Getter
public class HighlightUserPageDto {
    @Positive
    private long userId;

    private Long pageId;

    private String pageUrl;

    @AssertTrue
    private boolean isPageIdOrPageUrlExists() {
        return pageId != null || pageUrl != null;
    }
}
