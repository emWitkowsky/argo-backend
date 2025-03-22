package com.startup.argo.pack.dto;

import com.startup.argo.pack.enums.PackColor;
import com.startup.argo.pack.model.Pack;
import jakarta.annotation.Nonnull;

import java.math.BigDecimal;
import java.util.UUID;

public record PackResponseDto(
        UUID id,
        String name,
        BigDecimal price,
        String description,
        PackColor color

) {
    public static PackResponseDto from(@Nonnull Pack pack) {
        return new PackResponseDto(
                pack.getId(),
                pack.getName(),
                pack.getPrice(),
                pack.getDescription(),
                pack.getColor()

        );
    }
}
