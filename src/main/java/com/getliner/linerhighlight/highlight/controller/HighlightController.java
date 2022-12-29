package com.getliner.linerhighlight.highlight.controller;

import com.getliner.linerhighlight.highlight.dto.HighlightPostDto;
import com.getliner.linerhighlight.highlight.entity.Highlight;
import com.getliner.linerhighlight.highlight.mapper.HighlightMapper;
import com.getliner.linerhighlight.highlight.service.HighlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/highlights")
@Validated
@RequiredArgsConstructor
public class HighlightController {
    private final HighlightService highlightService;
    private final HighlightMapper mapper;

    @PostMapping
    public ResponseEntity postHighlight(@Valid @RequestBody HighlightPostDto highlightPostDto) {
        Highlight highlight = mapper.highlightPostDtoToHighlight(highlightPostDto);

        Highlight createdHighlight = highlightService.createHighlight(highlight);

        return new ResponseEntity<>(mapper.highlightToHighlightResponseDto(createdHighlight), HttpStatus.CREATED);
    }

}
