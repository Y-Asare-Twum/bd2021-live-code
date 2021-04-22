package org.example.hrm.dao;

import org.example.Dao;
import org.example.hrm.domain.Job;

import javax.persistence.EntityManager;

public class JobDao extends Dao<Job, Long> {

    private static JobDao instance;

    private JobDao(EntityManager em) {
        super(em);
    }

    public static JobDao instance(EntityManager em) {
        if (instance == null) {
            instance = new JobDao(em);
        }
        return instance;
    }

}
