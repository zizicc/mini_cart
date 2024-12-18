create table mydatabase.users
(
    id                  bigint auto_increment primary key,
    name        varchar(250),
    email       varchar(250),
    password    varchar(250),
    roles varchar(500)
);