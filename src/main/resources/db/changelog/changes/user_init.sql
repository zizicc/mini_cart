create table mydatabase.users
(
    id                  bigint auto_increment primary key,
    user_name        varchar(250),
    user_email       varchar(250),
    user_password    varchar(250),
    user_roles varchar(500)
);