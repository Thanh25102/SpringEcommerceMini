create database TranTuyen;
use TranTuyen;
# drop database TranTuyen;
create table `orders`
(
    id          bigint primary key auto_increment,
    `status`    varchar(50) not null,
    quantity    int         not null,
    created_at  date        not null,
    customer_id bigint      not null
);
create table cart
(
    id          bigint primary key auto_increment,
    quantity    int    not null,
    customer_id bigint not null,
    product_id  bigint not null
);
create table customer
(
    id       bigint primary key auto_increment,
    name     varchar(255) not null,
    username varchar(255) not null,
    password varchar(64)  not null,
    avatar varchar(500) null
);
create table orderdetail
(
    id         bigint primary key auto_increment,
    quantity   int    not null,
    order_id   bigint not null,
    product_id bigint not null
);
create table product
(
    id       bigint primary key auto_increment,
    name     varchar(255)   not null,
    price    decimal(10, 2) not null,
    color    varchar(255)   not null,
    category varchar(255)   not null,
    brand    varchar(255)   not null
);
alter table `orders`
    add foreign key (customer_id) references customer (id);
alter table cart
    add foreign key (customer_id) references customer (id);
alter table cart
    add foreign key (product_id) references product (id);
alter table orderdetail
    add foreign key (order_id) references `orders` (id);
alter table orderdetail
    add foreign key (product_id) references product (id);

