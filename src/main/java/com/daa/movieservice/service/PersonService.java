package com.daa.movieservice.service;

import com.daa.movieservice.api.dto.PersonDto;
import com.daa.movieservice.api.dto.ShortPersonDto;
import com.daa.movieservice.model.Person;
import com.daa.movieservice.model.Role;
import com.daa.movieservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.daa.movieservice.utils.PersonMapper.mapPersonToPersonDto;
import static com.daa.movieservice.utils.PersonMapper.mapPersonToShortPersonDto;

@Service
@RequiredArgsConstructor
public class PersonService {

    @Autowired
    private final PersonRepository personRepository;

    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    public PersonDto getPersonById(Long id) {
        return personRepository.findById(id)
                .map(mapPersonToPersonDto)
                .get();
    }

    public List<String> getRoleByPersonsId(Long id) {
        Person person = personRepository.findById(id).get();

        return person.getRoles().stream()
                .map(Role::getRoleName).peek(System.out::println)
                .collect(Collectors.toList());
    }

    public List<ShortPersonDto> searchPersonByName(String name) {
        return personRepository.findPersonByLastNameContains(name)
                .stream()
                .limit(3)
                .map(mapPersonToShortPersonDto)
                .collect(Collectors.toList());
    }
}
