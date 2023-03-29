create database TranTuyen;
use  TranTuyen;
# drop database TranTuyen;
create table `Orders`(
    id bigint primary key auto_increment,
    `status` varchar(50) not null,
    quantity int not null,
    created_at date not null,
    customer_id bigint not null
);
create table Cart(
    id bigint primary key auto_increment,
    quantity int not null,
    customer_id bigint not null,
    product_id bigint not null
);
create table Customer(
    id bigint primary key auto_increment,
    name varchar(255) not null,
    username varchar(255) not null,
    password varchar(64) not null
);
create table OrderDetail(
    id bigint primary key auto_increment,
    quantity int not null,
    order_id bigint not null,
    product_id bigint not null
);
create table Product(
    id bigint primary key auto_increment,
    name varchar(255) not null,
    price decimal(10,2) not null,
    color varchar(255) not null,
    category varchar(255) not null,
    brand varchar(255) not null
);
alter table `Orders` add foreign key (customer_id) references Customer(id);
alter table Cart add foreign key (customer_id) references Customer(id);
alter table Cart add foreign key (product_id) references Product(id);
alter table OrderDetail add foreign key (order_id) references `Orders`(id);
alter table OrderDetail add foreign key (product_id) references Product(id);
