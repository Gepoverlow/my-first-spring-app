package dev.first.repository;

import dev.first.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository implements CrudRepository{

    @Override
    public List getAll() {

        List<Person> persons = new ArrayList<>();
        Person myself = new Person(29, "Lucas", "Stocker");
        persons.add(myself);
        return persons;

    }
}
