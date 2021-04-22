package org.example.pubs;

import java.util.List;

import static org.example.Em.em;

public class PubsApp {

    public static void main(String[] args) {
        new PubsApp().run();
    }

    private void run() {
        AuthorDao dao = AuthorDao.instance(em);
        List<Author> all = dao.findAll();
        all.forEach(System.out::println);
    }

}
