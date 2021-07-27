create sequence hibernate_sequence start 1 increment 1;
create table account
(
    id            int4 not null,
    city          varchar(255),
    frist_name    varchar(255),
    last_name     varchar(255),
    mail          varchar(255),
    password      varchar(255),
    phone_number  varchar(255),
    postal_adress varchar(255),
    pseudo        varchar(255),
    primary key (id)
);
create table blibliotheque
(
    id           int4 not null,
    city         varchar(255),
    name         varchar(255),
    streetnumber varchar(255),
    surface      int4,
    primary key (id)
);
create table book
(
    book_id        int4 not null,
    book_available boolean,
    author         varchar(255),
    editor         varchar(255),
    kind           varchar(255),
    ref            varchar(255),
    synopsis       varchar(255),
    title          varchar(255),
    id_examplary   int4,
    primary key (book_id)
);
create table borrowing
(
    borrowing_id        int4 not null,
    end_date            date,
    extension           boolean,
    start_date          date,
    number_card_library int4,
    id_exemplaire       int4,
    primary key (borrowing_id)
);
create table exemplary
(
    id                 int4 not null,
    exemplairenumber   int4,
    remainingexemplary int4,
    id_blibliotheque   int4,
    primary key (id)
);
create table roles
(
    id         int4 not null,
    rolename   varchar(255),
    id_account int4,
    primary key (id)
);
alter table account
    add constraint UKi1gawxnhd94ot5ascbjggmaew unique (pseudo);
alter table account
    add constraint UKm93yt13m0ygub63ig996dudgo unique (mail);
alter table book
    add constraint FK1dx4be18tqs53v3dks5yyk9id foreign key (id_examplary) references exemplary;
alter table borrowing
    add constraint FKcky175fbst5fh3eetxe5g66lr foreign key (number_card_library) references account;
alter table borrowing
    add constraint FKaddqj9hb6fqkddmbgu34yq6ix foreign key (id_exemplaire) references exemplary;
alter table exemplary
    add constraint FKks8dmw9xirs8bge0ib6mkseca foreign key (id_blibliotheque) references blibliotheque;
alter table roles
    add constraint FK2gea6ik9rkf6bs6jliputhbbc foreign key (id_account) references account