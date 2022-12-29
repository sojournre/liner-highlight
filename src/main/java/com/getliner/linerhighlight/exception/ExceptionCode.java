package com.getliner.linerhighlight.exception;

import lombok.Getter;

public enum ExceptionCode {
    USER_NOT_FOUND(404, "User not found"),
    COLOR_NOT_FOUND(404, "Color not found"),
    COLOR_HEX_EXISTS(409, "Color Hex exists"),
    THEME_NOT_FOUND(404, "Theme not found"),
    THEME_COLOR_NOT_FOUND(404, "Theme Color not found")
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
