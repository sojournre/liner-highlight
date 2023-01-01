package com.getliner.linerhighlight.highlight.controller;

import com.getliner.linerhighlight.highlight.dto.HighlightPatchDto;
import com.getliner.linerhighlight.highlight.dto.HighlightPostDto;
import com.getliner.linerhighlight.highlight.dto.HighlightUserPageDto;
import com.getliner.linerhighlight.highlight.entity.Highlight;
import com.getliner.linerhighlight.highlight.mapper.HighlightMapper;
import com.getliner.linerhighlight.highlight.service.HighlightService;
import com.getliner.linerhighlight.response.MultiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

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

    @PatchMapping
    public ResponseEntity patchHighlight(@Valid @RequestBody HighlightPatchDto highlightPatchDto) {
        Highlight highlight = highlightService.updateHighlight(mapper.highlightPatchDtoToHighlight(highlightPatchDto));

        return new ResponseEntity<>(mapper.highlightToHighlightResponseDto(highlight), HttpStatus.OK);
    }

    @GetMapping("/user/mypage")
    public ResponseEntity getHighlights(@Positive @RequestParam(defaultValue = "1") int page,
                                        @Positive @RequestParam(defaultValue = "50") int size,
                                        @Valid @RequestBody HighlightUserPageDto highlightUserPageDto) {
        Page<Highlight> pageHighlights = highlightService.findWebpageHighlights(page - 1, size, highlightUserPageDto);
        List<Highlight> highlights = pageHighlights.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.highlightsToHighlightResponseDtos(highlights), pageHighlights),
                HttpStatus.OK
        );
    }

}
