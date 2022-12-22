package com.getliner.linerhighlight.highlight.controller;

import com.getliner.linerhighlight.highlight.mapper.HighlightMapper;
import com.getliner.linerhighlight.highlight.service.HighlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/highlights")
@Validated
@RequiredArgsConstructor
public class HighlightController {
    private final HighlightService highlightService;
    private final HighlightMapper mapper;
}
