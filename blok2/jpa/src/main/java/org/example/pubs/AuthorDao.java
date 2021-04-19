package org.example.pubs;

import org.example.Dao;

import javax.persistence.EntityManager;

public class AuthorDao extends Dao<Author, String> {

    public AuthorDao(EntityManager em) {
        super(em);
    }

}
