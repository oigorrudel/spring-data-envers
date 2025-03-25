package br.xksoberbado.spring3dataenvers.repository;

import br.xksoberbado.spring3dataenvers.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import java.util.UUID;

public interface PersonRepository
    extends JpaRepository<Person, UUID>,
    RevisionRepository<Person, UUID, Long> {
}
