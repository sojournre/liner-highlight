package com.getliner.linerhighlight.page.service;

import com.getliner.linerhighlight.page.entity.Page;
import com.getliner.linerhighlight.page.repository.PageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PageService {
    private final PageRepository pageRepository;

    public Page findVerifiedPage(String pageUrl) {
        Optional<Page> optionalPage = pageRepository.findByPageUrl(pageUrl);
        Page findPage = optionalPage.orElseGet(Page::new);
        if (findPage.getPageId() == null) {
            findPage.setPageUrl(pageUrl);
//            pageRepository.save(findPage);
        }
        return findPage;
    }
}
