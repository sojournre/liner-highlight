package com.getliner.linerhighlight.theme.repository;

import com.getliner.linerhighlight.color.entity.Color;
import com.getliner.linerhighlight.theme.entity.Theme;
import com.getliner.linerhighlight.theme.entity.ThemeColor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ThemeColorRepository extends JpaRepository<ThemeColor, Long> {
    Optional<ThemeColor> findByThemeAndColor(Theme theme, Color color);
}
