package com.getliner.linerhighlight.page.service;

import com.getliner.linerhighlight.exception.BusinessLogicException;
import com.getliner.linerhighlight.exception.ExceptionCode;
import com.getliner.linerhighlight.page.entity.Webpage;
import com.getliner.linerhighlight.page.repository.PageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PageService {
    private final PageRepository pageRepository;

    public Webpage createWebpage(String pageUrl) {
        Optional<Webpage> optionalPage = pageRepository.findByPageUrl(pageUrl);
        Webpage findWebpage = optionalPage.orElseGet(Webpage::new);
        if (findWebpage.getPageId() == null) {
            findWebpage.setPageUrl(pageUrl);
//            pageRepository.save(findPage);
        }
        return findWebpage;
    }

    public Webpage findVerifiedWebpage(long pageId) {
        Optional<Webpage> optionalWebpage = pageRepository.findById(pageId);

        return optionalWebpage.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.PAGE_NOT_FOUND));
    }

    public Webpage findVerifiedWebpage(String pageUrl) {
        Optional<Webpage> optionalWebpage = pageRepository.findByPageUrl(pageUrl);

        return optionalWebpage.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.PAGE_NOT_FOUND));
    }
}
