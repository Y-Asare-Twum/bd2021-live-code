package org.example.hrm.dao;

import org.example.Dao;
import org.example.hrm.domain.Laptop;

import javax.persistence.EntityManager;

public class LaptopDao extends Dao<Laptop, Long> {

    private static LaptopDao instance;

    private LaptopDao(EntityManager em) {
        super(em);
    }

    public static LaptopDao instance(EntityManager em) {
        if (instance == null) {
            instance = new LaptopDao(em);
        }
        return instance;
    }

}
