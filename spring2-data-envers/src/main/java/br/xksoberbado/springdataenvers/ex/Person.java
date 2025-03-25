package br.xksoberbado.springdataenvers.ex;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

@Data
@Entity
@Audited
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    @NotAudited
    private String motherName;

    @Version
    private Long version;

    protected Person() {
    }

    public Person(final String name, final Integer age) {
        this.name = name;
        this.age = age;
    }
}
