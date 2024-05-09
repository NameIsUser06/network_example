package com.network.domain.pet.service;

import com.network.domain.person.domain.Person;
import com.network.domain.person.domain.repository.PersonRepository;
import com.network.domain.pet.domain.Pet;
import com.network.domain.pet.domain.repository.PetRepository;
import com.network.domain.pet.presentation.dto.CreatePetRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final PersonRepository personRepository;

    public String create(CreatePetRequestDto dto) {
        Optional<Person> person = personRepository.findByName(dto.user_name());

        if (person.isPresent()) {
            Pet pet = Pet.builder()
                    .name(dto.pet_name())
                    .person(person.get())
                    .category(dto.type())
                    .build();
            petRepository.save(pet);
            return "success";
        }
        return "fail";
    }
}
