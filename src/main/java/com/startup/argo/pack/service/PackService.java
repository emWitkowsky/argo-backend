package com.startup.argo.pack.service;

import com.startup.argo.pack.dto.PackCreateRequestDto;
import com.startup.argo.pack.dto.PackResponseDto;
import com.startup.argo.pack.model.Pack;
import com.startup.argo.pack.repository.PackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PackService {

    private final PackRepository packRepository;

    public List<PackResponseDto> getAllPacks() {
        return packRepository.findAll().stream().map(PackResponseDto::from).toList();
    }


    public PackResponseDto getPackById(UUID id) {
        Pack pack = getPackOrThrow(id);

        return PackResponseDto.from(pack);
    }

    public void deletePack(UUID id) {
        Pack pack = getPackOrThrow(id);

        packRepository.delete(pack);
    }

    private Pack getPackOrThrow(UUID id) {
        Optional<Pack> newsOrNull = packRepository.findById(id);
        return newsOrNull.orElseThrow(
                () -> new RuntimeException("Pack not found"));
    }

    public PackResponseDto updatePack(UUID id, PackCreateRequestDto packCreateRequestDto) {
        Pack pack = getPackOrThrow(id);

        pack.setName(packCreateRequestDto.name());
        pack.setPrice(packCreateRequestDto.price());
        pack.setDescription(packCreateRequestDto.description());
        pack.setColor(packCreateRequestDto.color());

        Pack savedPack = packRepository.save(pack);

        return PackResponseDto.from(savedPack);
    }

    public PackResponseDto createPack(PackCreateRequestDto packCreateRequestDto) {
        Pack pack = new Pack();

        pack.setName(packCreateRequestDto.name());
        pack.setPrice(packCreateRequestDto.price());
        pack.setDescription(packCreateRequestDto.description());
        pack.setColor(packCreateRequestDto.color());

        return PackResponseDto.from(pack);
    }
}
