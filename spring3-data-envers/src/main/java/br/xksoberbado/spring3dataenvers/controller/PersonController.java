package br.xksoberbado.spring3dataenvers.controller;

import br.xksoberbado.spring3dataenvers.controller.dto.request.PersonBody;
import br.xksoberbado.spring3dataenvers.model.Person;
import br.xksoberbado.spring3dataenvers.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.history.Revisions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository repository;

    @GetMapping
    public List<Person> get() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Person getById(@PathVariable final UUID id) {
        return repository.findById(id)
            .orElseThrow();
    }

    @PostMapping
    public Person post(@RequestBody final PersonBody body) {
        final var person = Person.builder()
            .id(UUID.randomUUID())
            .name(body.name())
            .build();

        return repository.save(person);
    }

    @PutMapping("{id}")
    public Person put(@PathVariable final UUID id,
                      @RequestBody final PersonBody body) {
        return repository.findById(id)
            .map(person -> {
                person.setName(body.name());

                return repository.save(person);
            })
            .orElseThrow();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final UUID id) {
        repository.deleteById(id);
    }

    @GetMapping("{id}/revisions")
    public Revisions<Long, Person> getRevisions(@PathVariable final UUID id) {
        return repository.findRevisions(id);
    }
}
