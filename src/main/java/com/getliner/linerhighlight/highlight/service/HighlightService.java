package com.getliner.linerhighlight.highlight.service;

import com.getliner.linerhighlight.exception.BusinessLogicException;
import com.getliner.linerhighlight.exception.ExceptionCode;
import com.getliner.linerhighlight.highlight.dto.HighlightUserPageDto;
import com.getliner.linerhighlight.highlight.entity.Highlight;
import com.getliner.linerhighlight.highlight.repository.HighlightRepository;
import com.getliner.linerhighlight.page.entity.Webpage;
import com.getliner.linerhighlight.page.service.PageService;
import com.getliner.linerhighlight.theme.entity.ThemeColor;
import com.getliner.linerhighlight.theme.service.ThemeColorService;
import com.getliner.linerhighlight.user.entity.User;
import com.getliner.linerhighlight.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Webpage verifiedWebpage = pageService.createWebpage(highlight.getWebpage().getPageUrl());
        highlight.setWebpage(verifiedWebpage);
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
        // TODO 이미 저장된 highlight 인지 확인

        return themeColorService.findVerifiedThemeColor(userThemeId, highlight.getThemeColor());
    }

    public Page<Highlight> findWebpageHighlights(int page, int size, HighlightUserPageDto highlightUserPageDto) {
        User verifiedUser = userService.findVerifiedUser(highlightUserPageDto.getUserId());
        Webpage webpage;
        if (highlightUserPageDto.getPageId() != null) {
            webpage = pageService.findVerifiedWebpage(highlightUserPageDto.getPageId());
        } else {
            webpage = pageService.findVerifiedWebpage(highlightUserPageDto.getPageUrl());
        }

        return highlightRepository.findByUserAndWebpage(verifiedUser, webpage,
                PageRequest.of(page, size, Sort.by("updatedAt").descending()));
    }
}
