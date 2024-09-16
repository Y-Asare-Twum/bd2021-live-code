package org.example.pubs;

import org.example.Dao;

import javax.persistence.EntityManager;

public class AuthorDao extends Dao<Author, String> {

    private static AuthorDao instance;

    public AuthorDao(EntityManager em) {
        super(em);
    }

    public static AuthorDao instance(EntityManager em) {
        if (instance == null) {
            instance = new AuthorDao(em);
        }
        return instance;
    }

}
