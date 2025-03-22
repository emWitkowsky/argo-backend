package com.startup.argo.pack.dto;

import com.startup.argo.pack.enums.PackColor;

import java.math.BigDecimal;

public record PackCreateRequestDto(
        String name,
        BigDecimal price,
        String description,
        PackColor color
) {
}
