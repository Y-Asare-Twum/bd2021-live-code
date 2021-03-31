package org.example.java11.slides.h8;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class IbanTest {

    @Test
    void whenTwoIbansAreCreatedThenTheReferencesAreUniqueButTheIbansAreEqual() {
        Iban vanBram1 = Iban.of("NL89", "RABO0", "315044462");
        Iban vanBram2 = Iban.of("NL89", "RABO0", "315044462");

        assertThat(vanBram1 == vanBram2).isFalse();
        assertThat(vanBram1.equals(vanBram2)).isTrue(); // assertThat(vanBram1).isEqualTo(vanBram2);
    }

    @Test
    void whenTwoIbansAreCreatedThenOnlyOneCanBeAddedInASet() {
        Iban vanBram1 = Iban.of("NL89", "RABO0", "315044462");
        Iban vanBram2 = Iban.of("DE89", "RABO0", "315044462");
        Iban vanJan = Iban.of("NL23", "RABO0", "345345666");

        // type erasure: Set<Iban> wordt Set (dus Set<Object>)
        Set<Iban> ibans = new HashSet<>(); // key (hashcode) --> bucket met ibans (equals)

        System.out.println(vanBram1.hashCode());
        System.out.println(vanBram2.hashCode());

        ibans.add(vanBram1);
        ibans.add(vanBram2);
        ibans.add(vanJan);

        assertThat(ibans.size()).isEqualTo(2);
    }

    @Disabled // TODO: move to other test
    @Test
    void equalsOrIsIs() {
        long l1 = 123;
        long l2 = 123;

        Long n1 = new Long(123);
        Long n2 = new Long(123);
        System.out.println(n2);//?
        System.out.println(n1.equals(n2));//?
        System.out.println(n1 == n2);//?

        System.out.println(n1.toString() == n2.toString());
        String s1 = "123";
        String s2 = "123";

        System.out.println(s1 == s2);
    }
}
