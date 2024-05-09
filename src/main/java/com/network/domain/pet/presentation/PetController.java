package com.network.domain.pet.presentation;

import com.network.domain.pet.presentation.dto.CreatePetRequestDto;
import com.network.domain.pet.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pet")
public class PetController {
    private final PetService petService;

    @PostMapping
    public String addPet(@RequestBody CreatePetRequestDto dto) {
        return petService.create(dto);
    }
}
