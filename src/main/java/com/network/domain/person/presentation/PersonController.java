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

    @GetMapping("/{id}")
    public ResponseEntity<String> getName(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getName(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonResponseDto>> getPersonInfo() {
        return ResponseEntity.ok(personService.getInfo());
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<PersonResponseDto>> getFetchPersonInfo() {
        return ResponseEntity.ok(personService.getFetchInfo());
    }
}
