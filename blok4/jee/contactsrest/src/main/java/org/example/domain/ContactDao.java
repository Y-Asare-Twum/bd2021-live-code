package org.example.domain;

import org.example.util.ContactDAO;
import org.slf4j.Logger;

import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionManagementType.CONTAINER;
import static org.example.util.Response.throwBadRequest;

// @ApplicationScoped // Managed CDI bean, dus geen super powers
@Stateless //            Managed Enterprise Java Bean (EJB): hij krijgt super powers (zoals transaction capabilities).
//                       Stateless: de container maakt bij elk request een nieuwe instance;
//                       de class kan dus ook beter geen data-fields bevatten (dat heeft geen zin)!
@TransactionManagement(CONTAINER) // = default; whole annotation can be omitted when choosing CONTAINER
@ContactDAO
public class ContactDao implements IDao<Contact> {

    // STATE: doesn't make sense in Stateless EJB.
    // private String name;

    @PersistenceContext // Container managed EntityManager
    private EntityManager em;

    @Inject Logger log;

    // BEHAVIOUR:

    @Override
    public List<Contact> get(String q) {
        return q == null ?
                em.createNamedQuery("Contact.findAll", Contact.class)
                        .getResultList() :
                em.createNamedQuery("Contact.findByQ", Contact.class)
                        .setParameter("q", "%" + q + "%")
                        .getResultList();
    }

    @Override
    public Optional<Contact> getById(Long id) {
        return Optional.ofNullable(em.find(Contact.class, id));
    }

    @Override
    @TransactionAttribute(REQUIRED)  // = default; whole annotation can be omitted when choosing REQUIRED.
    //                                  Deze methode wordt in een databasetransactie op de server uitgevoerd.
    //                                  Als er al een transactie loopt, gebruikt de server die, anders maakt hij een nieuwe transactie aan.
    public Contact add(Contact c) {
        em.persist(c);
        return c;
    }

    @Override
    @TransactionAttribute(REQUIRED)
    public void delete(Long id) {
        getById(id).ifPresentOrElse(em::remove, throwBadRequest(id));
    }

    @PreDestroy
    public void cleanUp() {
        log.debug("Bean is about to get destroyed. Cleaning up resources...");
        // Cleaning up resources..
    }

}
