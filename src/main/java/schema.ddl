
    create table Autonomia (
        id int8 not null,
        nombre varchar(50),
        primary key (id)
    );

    create table Provincia (
        id int8 not null,
        autonomia bytea,
        nombre varchar(50),
        primary key (id)
    );

    create table Usuario (
        id int8 not null,
        nombre varchar(20),
        role varchar(255),
        primary key (id)
    );

    alter table Autonomia 
        add constraint UK_kgqamit4tvvo4d4ehf6vi3sfb unique (nombre);

    alter table Provincia 
        add constraint UK_8mf2hn9jl0ilqosl320daxen6 unique (nombre);

    alter table Usuario 
        add constraint UK_j1akxw4c7oy4p7mrgudoai5p0 unique (nombre);
