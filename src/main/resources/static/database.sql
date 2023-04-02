create database TranTuyen;
use TranTuyen;
# drop database TranTuyen;
create table `orders`
(
    id           bigint primary key auto_increment,
    `status`     varchar(50)  not null,
    quantity     int          not null,
    first_name   varchar(255) not null,
    last_name    varchar(255) not null,
    company_name varchar(255) null,
    country      varchar(255) not null,
    address      varchar(255) not null,
    phone        varchar(255) not null,
    email        varchar(255) not null,
    created_at   date         not null,
    customer_id  bigint       not null
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
    avatar   varchar(500) null
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
    id          bigint primary key auto_increment,
    name        varchar(255)   not null,
    price       decimal(10, 2) not null,
    color       varchar(255)   not null,
    brand       varchar(255)   not null,
    image       varchar(255)   null,
    description varchar(1000)  null,
    category_id bigint         not null
);
create table category
(
    id   bigint primary key auto_increment,
    name varchar(255) not null
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
alter table product
    add foreign key (category_id) references category (id);

insert into category(name)
values ('Hamburger'),
       ('Cake'),
       ('Pizza');
insert into product(`name`, price, image, color, category_id, brand, `description`)
values ('SHRIMP HAMBURGER', 19.55, 'shop-shrimp-burger.png', 'RED', 1, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('CHICKEN HAMBURGER', 18.44, 'shop-chicken-burger.png', 'RED', 1, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('BEEF HAMBURGER', 20, 'shop-beef-burger.png', 'RED', 1, 'Lotteria', null),
       ('Big Mac Cheeseburger', 18.44, 'shop-big-mac-cheese-burger.png', 'RED', 1, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Double Buffalo burger', 18.44, 'shop-double-buffalo-burger.png', 'RED', 1, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Double Chicken burger', 18.44, 'shop-double-chicken-burger.png', 'RED', 1, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Fried Fish burger', 18.44, 'shop-fried-fish-burger.png', 'RED', 1, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Cheese Chicken burger', 18.44, 'shop-chese-chicken-burger.png', 'RED', 1, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Bacon burger', 18.44, 'shop-bacon-burger.png', 'RED', 1, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Bacon cheeseburger', 18.44, 'shop-bacon-chese-burger.png', 'RED', 1, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Jumpo Chicken burger', 18.44, 'shop-jumpo-chicken-burger.png', 'RED', 1, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Cheeseburger', 18.44, 'shop-chese-burger.png', 'RED', 1, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),

       ('Chocolate Cupcake', 18.44, 'shop-chocolate-cup-cake.png', 'RED', 2, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Red Velvet Cake', 18.44, 'shop-red-velvet-cake.png', 'RED', 2, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Chocolate Muffin Cake', 18.44, 'shop-chocolate-muffin-cake.png', 'RED', 2, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Chocolate Cake', 18.44, 'shop-chocolate-cake.png', 'RED', 2, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Peanut Chocolate Cake', 18.44, 'shop-peanut-chocolate-cake.png', 'RED', 2, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Strawberry Cake', 18.44, 'shop-strawberry-cake.png', 'RED', 2, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Mint Ice Cream Cake', 18.44, 'shop-mint-ice-cream-cake.png', 'RED', 2, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),

       ('Summer Pizza', 18.44, 'shop-summer-pizza.png', 'RED', 3, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Primo Meat Pizza', 18.44, 'shop-primo-meat-pizza.png', 'RED', 3, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Pepperoni Pizza', 18.44, 'shop-pepperoni-pizza.png', 'RED', 3, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('Italiano Original Pizza', 18.44, 'shop-italiano-original-pizza.png', 'RED', 3, 'KFC',
        'Testing description for product .......... ..................... ......................... ....................... ................ end ! '),
       ('shop-mushroom-sausage-pizza.png', 18.44, 'carne-pizza', 'RED', 3, 'KFC', null);
