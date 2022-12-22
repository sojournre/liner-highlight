package com.getliner.linerhighlight.highlight.repository;

import com.getliner.linerhighlight.highlight.entity.Highlight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HighlightRepository extends JpaRepository<Highlight, Long> {
}
