drop table if exists customers cascade;
create table customers (id bigserial primary key, name varchar(255));
insert into customers (name) values
    ('first customer'),
    ('second customer'),
    ('third customer');

drop table if exists products cascade;
create table products (id bigserial primary key, name varchar(255), price int);
insert into products (name, price) values
    ('first product', 10),
    ('second product', 15),
    ('third product', 20);

drop table if exists products_buyers cascade;
CREATE TABLE products_buyers (customer_id bigint, product_id bigint, FOREIGN KEY (customer_id) REFERENCES customers (id), FOREIGN KEY (product_id) REFERENCES products (id));
insert into products_buyers(customer_id, product_id) values
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 1),
    (2, 2),
    (2, 3),
    (3, 1);