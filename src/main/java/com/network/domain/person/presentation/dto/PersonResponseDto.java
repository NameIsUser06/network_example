package com.network.domain.person.presentation.dto;

import com.network.domain.pet.presentation.dto.PetResponseDto;

import java.util.List;

public record PersonResponseDto(
        String name,
        List<PetResponseDto> pets
) {
}
