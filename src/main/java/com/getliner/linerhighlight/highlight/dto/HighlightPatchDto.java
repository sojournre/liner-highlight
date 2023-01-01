package com.getliner.linerhighlight.highlight.dto;

import lombok.Getter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
public class HighlightPatchDto {
    @Positive
    private long highlightId;

    @Positive
    private long userId;

    private String colorHex;

    private String text;

    @AssertTrue
    private boolean isColorHexOrTextExists() {
        return colorHex != null || text != null;
    }
}
