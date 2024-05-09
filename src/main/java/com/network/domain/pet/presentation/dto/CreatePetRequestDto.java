package com.network.domain.pet.presentation.dto;

import com.network.domain.pet.domain.type.Category;

public record CreatePetRequestDto(
        String user_name,
        String pet_name,
        Category type
) {
}
