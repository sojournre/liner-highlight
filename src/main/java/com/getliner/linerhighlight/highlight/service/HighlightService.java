package com.getliner.linerhighlight.highlight.service;

import com.getliner.linerhighlight.highlight.entity.Highlight;
import com.getliner.linerhighlight.highlight.repository.HighlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HighlightService {
    private final HighlightRepository highlightRepository;

    public Highlight createHighlight(Highlight highlight) {
        return highlightRepository.save(highlight);
    }
}
