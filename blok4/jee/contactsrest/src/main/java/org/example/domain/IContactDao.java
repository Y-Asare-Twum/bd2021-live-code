package org.example.domain;

import java.util.List;
import java.util.Optional;

public interface IContactDao {
    List<Contact> get(String q);

    Optional<Contact> getById(Long id);

    Contact add(Contact c);

    void delete(Long id);
}
