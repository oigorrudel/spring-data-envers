package br.xksoberbado.spring2dataenvers.ex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface PersonRepository extends
    JpaRepository<Person, Long>,
    RevisionRepository<Person, Long, Long> {
}
