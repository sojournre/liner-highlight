package com.getliner.linerhighlight.highlight.mapper;

import com.getliner.linerhighlight.color.entity.Color;
import com.getliner.linerhighlight.highlight.dto.HighlightPatchDto;
import com.getliner.linerhighlight.highlight.dto.HighlightPostDto;
import com.getliner.linerhighlight.highlight.dto.HighlightResponseDto;
import com.getliner.linerhighlight.highlight.entity.Highlight;
import com.getliner.linerhighlight.page.entity.Page;
import com.getliner.linerhighlight.theme.entity.ThemeColor;
import com.getliner.linerhighlight.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HighlightMapper {
    default Highlight highlightPostDtoToHighlight(HighlightPostDto highlightPostDto) {
        if (highlightPostDto == null) {
            return null;
        }

        Highlight highlight = new Highlight();
        User user = new User();
        Page page = new Page();
        Color color = new Color();
        ThemeColor themeColor = new ThemeColor();

        user.setUserId(highlightPostDto.getUserId());
        page.setPageUrl(highlightPostDto.getPageUrl());
        color.setColorHex(highlightPostDto.getColorHex());
        themeColor.setColor(color);

        highlight.setUser(user);
        highlight.setPage(page);
        highlight.setText(highlightPostDto.getText());
        highlight.setThemeColor(themeColor);

        return highlight;
    }

    default Highlight highlightPatchDtoToHighlight(HighlightPatchDto highlightPatchDto) {
        if (highlightPatchDto == null) {
            return null;
        }

        Highlight highlight = new Highlight();
        User user = new User();
        Color color = new Color();
        ThemeColor themeColor = new ThemeColor();

        user.setUserId(highlightPatchDto.getUserId());
        color.setColorHex(highlightPatchDto.getColorHex());
        themeColor.setColor(color);

        highlight.setHighlightId(highlightPatchDto.getHighlightId());
        highlight.setUser(user);
        highlight.setText(highlightPatchDto.getText());
        highlight.setThemeColor(themeColor);

        return highlight;
    }

    default HighlightResponseDto highlightToHighlightResponseDto(Highlight highlight) {
        HighlightResponseDto highlightResponseDto = new HighlightResponseDto();
        highlightResponseDto.setHighlightId(highlight.getHighlightId());
        highlightResponseDto.setUserId(highlight.getUser().getUserId());
        highlightResponseDto.setPageId(highlight.getPage().getPageId());
        highlightResponseDto.setColorHex(highlight.getThemeColor().getColor().getColorHex());
        highlightResponseDto.setText(highlight.getText());

        return highlightResponseDto;
    }
}
