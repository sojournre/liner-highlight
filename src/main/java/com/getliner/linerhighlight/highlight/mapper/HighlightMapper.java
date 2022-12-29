package com.getliner.linerhighlight.highlight.mapper;

import com.getliner.linerhighlight.color.entity.Color;
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

    HighlightResponseDto highlightToHighlightResponseDto(Highlight highlight);
}
