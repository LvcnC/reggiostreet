create database reggioStreet;
use reggioStreet;

-- se c'è hibernate non ce ne bisogon
-- create table product(
-- prod_id int primary key auto_increment,
--    name varchar(40),
--    avg_price float,
--    category varchar(40),
--    qt int
-- );

insert into product 
(name,avg_price,category,qt)
values
("toilet paper",2.4,"sanitary",1),
("sugar",1.3,"food",2);