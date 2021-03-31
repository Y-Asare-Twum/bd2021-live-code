package org.example.java11.slides.h12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AuthorUtilTest {

    private AuthorUtil util;

    @BeforeEach
    void setUp() {
        util = new AuthorUtil();
    }

    @Test
    void whenShowAuthorOnAnnotatedClassThenItShowsTheAuthor() {
        Class<GamePlayer> c = GamePlayer.class;

        String classAuthor = util.showAuthorOnClass(c);

        assertEquals(classAuthor, "Bram");
    }

    @Test
    void whenShowAuthorOnNonAnnotatedClassThenItDoesntShowTheAuthor() {
        Class<SomeOtherClass> c = SomeOtherClass.class;

        String classAuthor = util.showAuthorOnClass(c);

        assertNull(classAuthor);
    }

    @Test
    void whenShowAuthorsOnMethodsOfAnnotatedClassThenAllAuthorsAreShown() {
        Class<GamePlayer> c = GamePlayer.class;

        List<String> methodAuthors = util.showAuthorsOnMethods(c);

        assertThat(methodAuthors).contains("Timo Kramer", "Menno Kramer");
    }

    @Test
    void whenShowAuthorsOnMethodsOfNonAnnotatedClassThenNoAuthorsAreShown() {
        Class<SomeOtherClass> c = SomeOtherClass.class;

        List<String> methodAuthors = util.showAuthorsOnMethods(c);

        assertThat(methodAuthors).isEmpty();
    }
}
