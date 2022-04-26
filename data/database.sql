use shop;
drop table customer, product, purchase, purchase_Product;


create table customer(
customer_id int(6) primary key auto_increment not null,
firstname varchar(255),
lastname varchar(255),
street varchar(255),
zipcode int,
town varchar(255),
house int
);

create table product(
product_id int(6) primary key auto_increment not null,
name varchar(255),
price double
);

create table purchase(
purchase_id int(6) primary key auto_increment not null,
customer_id int(6),
date timestamp,
Foreign Key(customer_Id) references customer(customer_Id)
);

create table purchase_product(
purchase_product_id int(6) primary key auto_increment not null,
purchase_Id int(6) not null,
product_Id int(6) not null,
FOREIGN Key(purchase_id) References purchase(purchase_id),
FOREIGN Key(product_id) References product(product_id)
);

Insert into customer(customer_Id, firstname, lastname, street, zipcode, town, house)
values
(1,'Annika','Pass','teststraße', '12555', 'Berlin','11'),
(2,'Sabine','Lorenz','teststraße', '12555', 'Berlin','12'),
(3,'Juliane','Russ','teststraße', '12555', 'Berlin','13')
;

insert into product(product_Id, name, price)
values (1, 'Brot', 2.55), (2, 'Apfel', 0.20), (3, 'Banane', 0.50);

insert into purchase(purchase_Id, customer_Id, date)
values (1,1,'2022-03-23 12:30:00'), (2,1,'2022-03-24 22:30:00'),(3,3,'2022-03-22 15:00:00'),
(4,2,'2022-03-25 09:15:00');

insert into purchase_product(purchase_Id, product_Id)
values(1,1),(1,2),(2,3),(1,3);
