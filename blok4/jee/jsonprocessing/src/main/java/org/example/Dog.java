package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

// @ToString
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Dog {

    // normal property
    public String name = "UNKNOWN";

    // will not get marshalled nor unmarshalled
    @JsonbTransient
    public int age = -1;

    // use different name in json
    @JsonbProperty("biteMe")
    public boolean bitable;

    // will not get marshalled (object --> json) by overriding the getter
    public String favoriteFood = "UNKNOWN";

    @JsonbTransient public String getFavoriteFood() { return favoriteFood; }

    // will not get unmarshalled (json --> object) by overriding the setter
    public String bossName = "UNKNOWN";

    @JsonbTransient public void setBossName(String bossName) { this.bossName = bossName; }

}
