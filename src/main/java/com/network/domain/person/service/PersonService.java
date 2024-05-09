package com.network.domain.person.service;

import com.network.domain.person.domain.Person;
import com.network.domain.person.domain.repository.PersonRepository;
import com.network.domain.person.presentation.dto.CreatePersonRequestDto;
import com.network.domain.person.presentation.dto.PersonResponseDto;
import com.network.domain.pet.presentation.dto.PetResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public void create(CreatePersonRequestDto dto) {
        Person person = Person.builder()
                .name(dto.name())
                .build();

        personRepository.save(person);
    }

    public List<PersonResponseDto> getInfo() {
        List<Person> persons = personRepository.findAll();
        return getPersonResponse(persons);
    }

    public List<PersonResponseDto> getFetchInfo() {
        List<Person> persons = personRepository.findAllFetchJoin();
        return getPersonResponse(persons);
    }

    private List<PersonResponseDto> getPersonResponse(List<Person> persons) {
        List<PersonResponseDto> responses = new ArrayList<>();

        for (Person person : persons) {
            List<PetResponseDto> pets = new ArrayList<>();
            person.getPets().forEach(
                    pet -> pets.add(new PetResponseDto(pet.getName(), pet.getCategory()))
            );
            responses.add(new PersonResponseDto(person.getName(), pets));
        }

        return responses;
    }

    public String getName(Long id) {
        Person person = personRepository.findById(id).orElseThrow();
        return person.getName();
    }
}
