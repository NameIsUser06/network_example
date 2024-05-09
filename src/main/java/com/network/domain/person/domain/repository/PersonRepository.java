package com.network.domain.person.domain.repository;

import com.network.domain.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByName(String name);
    @Query("select p from Person p join fetch p.pets")
    List<Person> findAllFetchJoin();
}
