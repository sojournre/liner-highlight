package com.getliner.linerhighlight.highlight.repository;

import com.getliner.linerhighlight.highlight.entity.Highlight;

import java.util.List;

public interface HighlightCustomRepository {
    List<Highlight> findByUser(long userId);
}
