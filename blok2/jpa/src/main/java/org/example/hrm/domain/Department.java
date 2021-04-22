package org.example.hrm.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department extends AbstractEntity {
    private String name;

    // Bidi, passive non-config side (passive, since FK is in join table, non-config since mappedBy/JoinTable is on the other side)
    @ManyToMany(mappedBy = "worksAt")
    private List<Person> employees = new ArrayList<>();

    public Department() { }

    public Department(String name) { this.name = name; }

    public void addPerson(Person e) { this.employees.add(e); }

    public String getName() { return name; }
}
