package com.network.domain.person.presentation;

import com.network.domain.person.presentation.dto.CreatePersonRequestDto;
import com.network.domain.person.presentation.dto.PersonResponseDto;
import com.network.domain.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addPerson(@RequestBody CreatePersonRequestDto dto) {
        personService.create(dto);
    }

    @GetMapping
    public ResponseEntity<List<PersonResponseDto>> getPersonInfo() {
        return ResponseEntity.ok(personService.getInfo());
    }
}
