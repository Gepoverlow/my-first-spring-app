package dev.first.service;

import dev.first.model.Person;
import dev.first.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements CrudService<Person> {

private PersonRepository personRepository;

public PersonService(PersonRepository personRepository){

    this.personRepository = personRepository;

}

    @Override
    public List read() {
        return personRepository.getAll();
    }

    @Override
    public Person create(Person person) {
        return null;
    }

    @Override
    public Optional<Person> get(int id) {
        return Optional.empty();
    }

    @Override
    public void delete(int id) {

    }
}
