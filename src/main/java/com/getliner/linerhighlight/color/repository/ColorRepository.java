package com.getliner.linerhighlight.color.repository;

import com.getliner.linerhighlight.color.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color, Long> {
    Optional<Color> findByColorHex(String colorHex);
}
