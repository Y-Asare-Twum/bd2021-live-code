package org.example;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class JsonBDemo {

    public static void main(String[] args) {
        Jsonb jsonb = JsonbBuilder.create();

        var dogObject = Dog.builder()
                .name("Hektor").age(42).bitable(true)
                .favoriteFood("meat").bossName("Bram")
                .build();

        // Marshalling ..............
        String marshalled = jsonb.toJson(dogObject);
        System.out.println("OBJ : " + dogObject);
        System.out.println("JSON: " + marshalled);

        System.out.println();

        // Unmarshalling ............
        final var dogJson = "{" +
                "\"name\":\"Snoopy\"," +
                "\"age\":4," +
                "\"bitable\":true," +
                "\"favoriteFood\":\"BBQ\"," +
                "\"bossName\":\"Charlie\"" +
                "}";

        Dog unmarshalled = jsonb.fromJson(dogJson, Dog.class);
        System.out.println("JSON: " + dogJson);
        System.out.println("OBJ : " + unmarshalled);
    }
}

