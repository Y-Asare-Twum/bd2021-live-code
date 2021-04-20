package org.example.hrm.dao;

import org.example.Dao;
import org.example.hrm.domain.Team;

import javax.persistence.EntityManager;

public class TeamDao extends Dao<Team, Long> {

    private static TeamDao instance;

    private TeamDao(EntityManager em) {
        super(em);
    }

    public static TeamDao instance(EntityManager em) {
        if (instance == null) {
            instance = new TeamDao(em);
        }
        return instance;
    }

}
