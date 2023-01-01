package com.getliner.linerhighlight.exception;

import lombok.Getter;

public enum ExceptionCode {
    USER_NOT_FOUND(404, "User not found"),
    USER_NOT_CORRECT(404, "User not correct"),
    COLOR_NOT_FOUND(404, "Color not found"),
    THEME_NOT_FOUND(404, "Theme not found"),
    THEME_COLOR_NOT_FOUND(404, "Theme Color not found"),
    HIGHLIGHT_NOT_FOUND(404, "Highlight not found"),
    COLOR_HEX_EXISTS(409, "Color Hex exists")
    ;

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
