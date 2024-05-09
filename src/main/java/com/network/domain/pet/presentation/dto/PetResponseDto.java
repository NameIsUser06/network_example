package com.network.domain.pet.presentation.dto;

import com.network.domain.pet.domain.type.Category;

public record PetResponseDto(
        String pet_name,
        Category category
) {
}
