package dev.first.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<Type> {

    List<Type> read();

    Type create(Type type);

    Optional<Type> get(int id);

    void delete(int id);

}
