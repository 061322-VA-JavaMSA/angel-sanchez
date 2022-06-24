-- users table for anyone that creates an username and password
create table if not exists users(
id serial primary key,
username varchar(256) unique not null check(length(username)>2),
password varchar(256) not null,
user_role varchar(256)
);

create table if not exists pokemon(
p_id int primary key,
p_name varchar(256),
description varchar(256),
owner_id int references users(id)
);

create table if not exists payment(
payment_id serial primary key,
date date default current_date,
amount int not null,
item_id int references pokemon(p_id),
owner_id int references users(id)
);

create table if not exists offers(
offer_id serial primary key,
status varchar(256) default 'pending',
item_id int references pokemon(p_id),
amount int not null,
user_id integer references users(id)
);



insert into users (username, password, user_role) values ('Asanchez', 'pass', 'manager');
insert into users (username, password, user_role) values ('AshKetchup', 'pikachu', 'customer');
insert into users (username, password, user_role) values ('R3D', 'snorlax', 'employee');


insert into pokemon(p_id, p_name, description, price) values (1, 'bulbusaur', 'Grass-type, looks like a flower with a bulb on its back', '25');
insert into pokemon(p_id, p_name, description, price) values (2, 'squirtle', 'Water-type, looks like a turtle', '10');
insert into pokemon(p_id, p_name, description, price) values (3, 'charmander', 'Fire-type, fire breathing lizard', '50');


alter table pokemon 
add price integer;

drop table if exists pokemon cascade;