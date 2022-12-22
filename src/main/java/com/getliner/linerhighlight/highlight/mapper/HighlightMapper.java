package com.getliner.linerhighlight.highlight.mapper;

import com.getliner.linerhighlight.highlight.dto.HighlightPostDto;
import com.getliner.linerhighlight.highlight.entity.Highlight;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HighlightMapper {
    Highlight highlightPostDtoToHighlight(HighlightPostDto highlightPostDto);
}
