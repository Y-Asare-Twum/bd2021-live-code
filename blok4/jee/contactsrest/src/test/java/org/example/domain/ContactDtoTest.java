package org.example.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ContactDtoTest {

    @Test
    void of() {
        final var firstName = "BRAAAAAM!";

        Contact jans = Contact.builder().id(100L).firstName(firstName).surname("Jans").email("fsdfdf@kfjdsf.com").build();
        ContactDto dto = ContactDto.of(jans);

        assertThat(dto.firstName).isEqualTo(firstName);
    }
}
