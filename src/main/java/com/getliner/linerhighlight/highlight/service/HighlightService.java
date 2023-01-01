package com.getliner.linerhighlight.highlight.service;

import com.getliner.linerhighlight.exception.BusinessLogicException;
import com.getliner.linerhighlight.exception.ExceptionCode;
import com.getliner.linerhighlight.highlight.entity.Highlight;
import com.getliner.linerhighlight.highlight.repository.HighlightRepository;
import com.getliner.linerhighlight.page.entity.Page;
import com.getliner.linerhighlight.page.service.PageService;
import com.getliner.linerhighlight.theme.entity.ThemeColor;
import com.getliner.linerhighlight.theme.service.ThemeColorService;
import com.getliner.linerhighlight.user.entity.User;
import com.getliner.linerhighlight.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HighlightService {
    private final HighlightRepository highlightRepository;
    private final UserService userService;
    private final PageService pageService;
    private final ThemeColorService themeColorService;

    public Highlight createHighlight(Highlight highlight) {
        // 유저가 존재하는지 확인
        ThemeColor themeColor = verifyHighlight(highlight);
        Page verifiedPage = pageService.findVerifiedPage(highlight.getPage().getPageUrl());
        highlight.setPage(verifiedPage);
        highlight.setThemeColor(themeColor);

        return highlightRepository.save(highlight);
    }

    public Highlight updateHighlight(Highlight highlight) {
        Highlight findHighlight = findVerifiedHighlight(highlight.getHighlightId());
        if (!Objects.equals(highlight.getUser().getUserId(), findHighlight.getUser().getUserId())) {
            throw new BusinessLogicException(ExceptionCode.USER_NOT_CORRECT);
        }

        Optional<ThemeColor> optionalThemeColor = Optional.ofNullable(highlight.getThemeColor());
        if (optionalThemeColor.isPresent()) {
            ThemeColor themeColor = verifyHighlight(highlight);
            findHighlight.setThemeColor(themeColor);
        }

        Optional.ofNullable(highlight.getText())
                .ifPresent(findHighlight::setText);

        return highlightRepository.save(findHighlight);
    }

    private Highlight findVerifiedHighlight(Long highlightId) {
        Optional<Highlight> optionalHighlight = highlightRepository.findById(highlightId);
        return optionalHighlight.orElseThrow(() -> new BusinessLogicException(ExceptionCode.HIGHLIGHT_NOT_FOUND));
    }

    private ThemeColor verifyHighlight(Highlight highlight) {
        User verifiedUser = userService.findVerifiedUser(highlight.getUser().getUserId());
        Long userThemeId = verifiedUser.getThemeId();
        // TODO colorHex의 값은 현재 설정된 테마 내 색 중에 하나인지 확인

        return themeColorService.findVerifiedThemeColor(userThemeId, highlight.getThemeColor());
    }
}
