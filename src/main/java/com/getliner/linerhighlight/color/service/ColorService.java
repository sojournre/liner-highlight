package com.getliner.linerhighlight.color.service;

import com.getliner.linerhighlight.color.entity.Color;
import com.getliner.linerhighlight.color.repository.ColorRepository;
import com.getliner.linerhighlight.exception.BusinessLogicException;
import com.getliner.linerhighlight.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColorService {
    private final ColorRepository colorRepository;

    public Color createColor(Color color) {
        String colorHex = color.getColorHex();

        verifyExistColor(colorHex);
        color.setColorHex(colorHex);

        return colorRepository.save(color);
    }

    public Color findVerifiedColor(String colorHex) {
        Optional<Color> color = colorRepository.findByColorHex(colorHex);

        return color.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.COLOR_NOT_FOUND));
    }

    private void verifyExistColor(String colorHex) {
        Optional<Color> color = colorRepository.findByColorHex(colorHex);
        if (color.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.COLOR_HEX_EXISTS);
        }
    }
}
