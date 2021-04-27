package com.daa.movieservice.api.restcontroller;

import com.daa.movieservice.api.dto.CrewDto;
import com.daa.movieservice.api.dto.PersonDto;
import com.daa.movieservice.api.dto.ShortPersonDto;
import com.daa.movieservice.model.Person;
import com.daa.movieservice.service.CrewService;
import com.daa.movieservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private final PersonService personService;
    @Autowired
    private final CrewService crewService;

    @GetMapping("/all")
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @GetMapping("/getPerson")
    public PersonDto getPersonById(@RequestParam(name = "personId") Long id){
        return personService.getPersonById(id);
    }

    @GetMapping("/getPersonCrews")
    public List<CrewDto> getPersonCrews(@RequestParam(name = "personId") Long id){
        return crewService.getCrewByPersonId(id);
    }

    @GetMapping("/getPersonRoles")
    public Map<String, List<String>> getPersonRoles(@RequestParam(name = "personId") Long id){
        Map<String, List<String>> map = new HashMap<>();
        map.put("roles", personService.getRoleByPersonsId(id));
        return map;
    }

    @GetMapping("/search/{name}")
    public List<ShortPersonDto> searchPersonByNameContains(@PathVariable(name = "name") String name){
        return personService.searchPersonByName(name);
    }
}
