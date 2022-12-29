package com.getliner.linerhighlight.theme.service;

import com.getliner.linerhighlight.exception.BusinessLogicException;
import com.getliner.linerhighlight.exception.ExceptionCode;
import com.getliner.linerhighlight.theme.entity.Theme;
import com.getliner.linerhighlight.theme.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ThemeService {
    private final ThemeRepository themeRepository;

    public Theme findVerifiedTheme(long themeId) {
        Optional<Theme> optionalTheme = themeRepository.findById(themeId);

        return optionalTheme.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.THEME_NOT_FOUND));
    }
}
