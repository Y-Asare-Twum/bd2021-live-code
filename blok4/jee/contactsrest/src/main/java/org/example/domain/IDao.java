package org.example.domain;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {
    List<T> get(String q);

    Optional<T> getById(Long id);

    T add(T c);

    void delete(Long id);
}
