package org.example.hrm.domain;

// javax: java eXtension

import lombok.*;
import org.example.Identifiable;
import org.example.hrm.BooleanTFConverter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
        @NamedQuery(name = "Person.find", query = "SELECT p FROM Person p WHERE p.id=:id")
})
public class Person implements Identifiable<Long> {

    // single fields:

    @Id @GeneratedValue
    private Long id;

    @Size(max = 200)
    private String name;

    private int age;

    @Convert(converter = BooleanTFConverter.class)
    private Boolean hasDriversLicence;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    private LocalTime creationTime;

    private LocalDate birthDate;

    // LocalDateTimeAttributeConverter has autoApply=true
    // @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime birthDateTime;

    @Enumerated(EnumType.STRING) // save enum name instead of ordinal
    private ContactType type;

    @Embedded
    private Address address;

    @Lob // CLOB Character large object
    @Basic(fetch = LAZY) // only loaded when explicitly called (with getResume()) on a managed object.
    private String resume;

    @Lob // BLOB Binary large object
    @Basic(fetch = LAZY)
    private byte[] image; // only loaded when explicitly called (with getImage()) on a managed object.

    // Relationships --------------------------------

    //      single valued (..ToOne)

    // UniDi
    @ManyToOne(cascade = MERGE/*, fetch = LAZY*/) // On merge cascade
    private Job job; // FK

    // BiDi
    @ManyToOne(cascade = MERGE/*, fetch = LAZY*/) // On merge cascade
    @ToString.Exclude // to break circular dependency with Team in tostring
    @EqualsAndHashCode.Exclude
    private Team scrumteam; // FK

    // UniDi
    @OneToOne(cascade = PERSIST, orphanRemoval = true)
    private Car leaseCar;

    //      collection valued (..ToMany)

    @OneToMany(cascade = PERSIST, fetch = LAZY)
    private Set<Laptop> laptops = new HashSet<>();

    // BiDi, passive config side (passive, since FK is in join table)
    @ManyToMany(cascade = PERSIST/*, mappedBy = "employees"*/) // either use mappedBy or use JoinTable on either manytomany side (of your choice); it doesn't matter which side
    @JoinTable(name = "persondepartment", // optional, to specify the names
            joinColumns = @JoinColumn(name = "personId"), // if JoinTable is omitted, JPA/Hibernate will generate it with default names
            inverseJoinColumns = @JoinColumn(name = "departmentId"))
    private Set<Department> worksAt = new HashSet<>();

    public void addLaptop(Laptop laptop) {
        this.laptops.add(laptop);
    }

    // BiDi relationships: update other side of relationship too
    public void setScrumteam(Team scrumteam) {
        this.scrumteam = scrumteam;
        scrumteam.addMember(this);
    }

    public void addWorksAt(Department d) {
        this.worksAt.add(d);
        d.addPerson(this);
    }
}
