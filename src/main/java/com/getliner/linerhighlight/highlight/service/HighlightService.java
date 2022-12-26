package com.getliner.linerhighlight.highlight.service;

import com.getliner.linerhighlight.highlight.entity.Highlight;
import com.getliner.linerhighlight.highlight.repository.HighlightRepository;
import com.getliner.linerhighlight.page.entity.Page;
import com.getliner.linerhighlight.page.service.PageService;
import com.getliner.linerhighlight.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HighlightService {
    private final HighlightRepository highlightRepository;
    private final UserService userService;
    private final PageService pageService;

    public Highlight createHighlight(Highlight highlight) {
        // 유저가 존재하는지 확인
        verifyHighlight(highlight);
        Page verifiedPage = pageService.findVerifiedPage(highlight.getPage().getPageUrl());
        highlight.setPage(verifiedPage);
        return highlightRepository.save(highlight);
    }

    private void verifyHighlight(Highlight highlight) {
        userService.findVerifiedUser(highlight.getUser().getUserId());
        // TODO colorHex의 값은 현재 설정된 테마 내 색 중에 하나인지 확인
    }
}
