create table if not exists person
(
    id   int auto_increment,
    name varchar(255) null,
    age  int          null,
    constraint person_id_uindex
        unique (id)
);

alter table person
    add primary key (id);

