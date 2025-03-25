package br.xksoberbado.springdataenvers.ex;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final PersonRepository repository;

    @GetMapping
    public Person get() {
        return repository.findById(1L)
            .orElse(null);
    }

    @GetMapping("create")
    public Person create() {
        return repository.save(new Person("José", 40));
    }

    @GetMapping("update-age/{age}")
    public Person updateAge(@PathVariable Integer age) {
        return repository.findById(1L)
            .map(person -> {
                person.setAge(age);
                return repository.save(person);
            })
            .orElse(null);
    }

    @GetMapping("update-mother")
    public Person updateMother() {
        return repository.findById(1L)
            .map(person -> {
                person.setMotherName("Mãe do José");
                return repository.save(person);
            })
            .orElse(null);
    }

    @GetMapping("delete")
    public void delete() {
        repository.deleteById(1L);
    }

    @GetMapping("revisions")
    public List<String> revisions() {
        return repository.findRevisions(1L)
            .stream()
            .map(Object::toString)
            .collect(Collectors.toList());
    }
}
