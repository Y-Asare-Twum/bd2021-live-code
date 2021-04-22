package org.example.hrm.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Address {
    private String street;
    private Integer housenumber;
    private String zip;
    private String city;
}
