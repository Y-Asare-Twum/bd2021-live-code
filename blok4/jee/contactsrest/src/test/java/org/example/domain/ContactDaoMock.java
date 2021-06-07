package org.example.domain;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

// Stateful! I can include state in this class.
@Alternative @ApplicationScoped // ≈ @Injectable
public class ContactDaoMock implements IDao<Contact> {

    // STATE:

    private final Contact.ContactBuilder cb = Contact.builder();

    private final List<Contact> contacts = new ArrayList<>(List.of(
            cb.firstName("Bram").surname("Janssens").email("s.a.janssens@gmail.com").age(41).id(1L).build(),
            cb.firstName("Joop").surname("Janssens").email("j.janssens@gmail.com").age(23).id(2L).build(),
            cb.firstName("Mieke").surname("Janssens").email("m.janssens@gmail.com").age(45).id(3L).build()
    ));

    // BEHAVIOUR:

    public List<Contact> get(String q) {
        return q == null ? this.contacts :
                contacts.stream()
                        .filter(c -> c.getFirstName().contains(q))
                        .collect(toList());
    }

    public Optional<Contact> getById(Long id) {
        return this.contacts.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public Contact add(Contact c) {
        this.contacts.add(c);
        return c;
    }

    @Override
    public void delete(Long id) {
        getById(id).ifPresent(this.contacts::remove);
    }
}

