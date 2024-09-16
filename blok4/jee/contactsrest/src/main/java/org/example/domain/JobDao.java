package org.example.domain;

import org.example.util.JobDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static org.example.util.Response.throwBadRequest;

@Stateless @JobDAO
public class JobDao implements IDao<Job> {

    // STATE: doesn't make sense in Stateless EJB.
    // private String name;

    @PersistenceContext // Container managed EntityManager
    private EntityManager em;

    @Override
    public List<Job> get(String q) {
        return q == null ?
                em.createNamedQuery("Job.findAll", Job.class).getResultList() :
                em.createNamedQuery("Job.findByQ", Job.class)
                        .setParameter("q", "%" + q + "%").getResultList();
    }

    @Override
    public Optional<Job> getById(Long id) {
        return Optional.ofNullable(em.find(Job.class, id));
    }

    @Override
    public Job add(Job c) {
        return em.merge(c);
    }

    @Override
    public void delete(Long id) {
        getById(id).ifPresentOrElse(em::remove, throwBadRequest(id));
    }

}
