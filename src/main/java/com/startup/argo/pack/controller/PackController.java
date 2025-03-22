package com.startup.argo.pack.controller;

import com.startup.argo.pack.dto.PackCreateRequestDto;
import com.startup.argo.pack.dto.PackResponseDto;
import com.startup.argo.pack.enums.PackColor;
import com.startup.argo.pack.model.Pack;
import com.startup.argo.pack.service.PackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pack")
@RequiredArgsConstructor
public class PackController {

    private final PackService packService;

    @GetMapping
    public List<PackResponseDto> getAllPacks() {
        return packService.getAllPacks();
    }

    @GetMapping("/{id}")
    public PackResponseDto getPackById(@PathVariable UUID id) {
        return packService.getPackById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePack(@PathVariable UUID id) {
        packService.deletePack(id);
    }

    @PutMapping("/{id}")
    public PackResponseDto updatePack(@PathVariable UUID id, @RequestParam String name, @RequestParam BigDecimal price,
                                      @RequestParam String description, PackColor color) {
        PackCreateRequestDto packCreateRequestDto = new PackCreateRequestDto(name, price, description, color);

        return packService.updatePack(id, packCreateRequestDto);
    }

    @PostMapping
    public PackResponseDto createPack(@RequestParam String name, @RequestParam BigDecimal price,
                                      @RequestParam String description, PackColor color) {
        PackCreateRequestDto packCreateRequestDto = new PackCreateRequestDto(name, price, description, color);

        return packService.createPack(packCreateRequestDto);
    }

}
