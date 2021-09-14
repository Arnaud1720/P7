create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to "Admin";

create table app_role
(
    id integer not null
        constraint app_role_pkey
            primary key,
    role_id integer not null,
    role_name varchar(30) not null
        constraint app_role_uk
            unique
);

alter table app_role owner to "Admin";

create table account
(
    id integer not null
        constraint account_pkey
            primary key,
    city varchar(255),
    frist_name varchar(255),
    last_name varchar(255)
        constraint uk9dy9mm9w0y2fdi25288gv4c8j
            unique,
    mail varchar(255)
        constraint ukm93yt13m0ygub63ig996dudgo
            unique,
    password varchar(255),
    phone_number varchar(255),
    postal_adress varchar(255),
    pseudo varchar(255)
        constraint uki1gawxnhd94ot5ascbjggmaew
            unique
);

alter table account owner to "Admin";

create table blibliotheque
(
    id integer not null
        constraint blibliotheque_pkey
            primary key,
    city varchar(255),
    name varchar(255),
    streetnumber varchar(255),
    surface integer
);

alter table blibliotheque owner to "Admin";

create table exemplary
(
    id integer not null
        constraint exemplary_pkey
            primary key,
    exemplairenumber integer,
    remainingexemplary integer,
    id_blibliotheque integer
        constraint fkks8dmw9xirs8bge0ib6mkseca
            references blibliotheque
);

alter table exemplary owner to "Admin";

create table book
(
    book_id integer not null
        constraint book_pkey
            primary key,
    book_available boolean,
    author varchar(255),
    editor varchar(255),
    kind varchar(255),
    ref varchar(255),
    synopsis varchar(255),
    title varchar(255),
    id_examplary integer
        constraint fk1dx4be18tqs53v3dks5yyk9id
            references exemplary
);

alter table book owner to "Admin";

create table borrowing
(
    borrowing_id integer not null
        constraint borrowing_pkey
            primary key,
    end_date date,
    extension boolean,
    start_date date,
    accountid integer
        constraint fkitggu5goqpk713cpgfh9m4jfx
            references account,
    id_exemplaire integer
        constraint fkaddqj9hb6fqkddmbgu34yq6ix
            references exemplary
);

alter table borrowing owner to "Admin";

create table roles
(
    id integer not null
        constraint roles_pkey
            primary key,
    rolename varchar(255),
    id_account integer
        constraint fk2gea6ik9rkf6bs6jliputhbbc
            references account
);

alter table roles owner to "Admin";

