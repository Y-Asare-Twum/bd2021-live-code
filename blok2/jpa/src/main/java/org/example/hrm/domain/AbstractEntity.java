package org.example.hrm.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id @GeneratedValue
    protected long id;

    public long getId() { return id; }
}
