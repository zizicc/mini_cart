create table mydatabase.products
(
    id                  bigint auto_increment primary key,
    product_name        varchar(250) not null,
    product_description varchar(500) not null
);