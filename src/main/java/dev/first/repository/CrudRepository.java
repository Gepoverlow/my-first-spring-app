package dev.first.repository;

import java.util.List;

public interface CrudRepository<Type> {

    List<Type> getAll();

}
