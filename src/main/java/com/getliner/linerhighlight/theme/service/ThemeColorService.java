package com.getliner.linerhighlight.theme.service;

import com.getliner.linerhighlight.color.entity.Color;
import com.getliner.linerhighlight.color.service.ColorService;
import com.getliner.linerhighlight.exception.BusinessLogicException;
import com.getliner.linerhighlight.exception.ExceptionCode;
import com.getliner.linerhighlight.theme.entity.Theme;
import com.getliner.linerhighlight.theme.entity.ThemeColor;
import com.getliner.linerhighlight.theme.repository.ThemeColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ThemeColorService {
    private final ThemeColorRepository themeColorRepository;
    private final ThemeService themeService;
    private final ColorService colorService;

    public ThemeColor findVerifiedThemeColor(long themeId, ThemeColor themeColor) {
        Theme theme = themeService.findVerifiedTheme(themeId);
        Color color = colorService.findVerifiedColor(themeColor.getColor().getColorHex());
        Optional<ThemeColor> optionalThemeColor = themeColorRepository.findByThemeAndColor(theme, color);

        return optionalThemeColor.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.THEME_COLOR_NOT_FOUND));
    }
}
