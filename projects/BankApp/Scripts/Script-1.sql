drop table reimbursement_status; 
drop table reimbursement;
drop table reimbursement_type;
drop table users;
drop table user_roles; 

create table if not exists users(
user_id serial primary key,
username varchar(50) unique not null check(length(username)>2),
password varchar(50) not null,
first_name varchar(100),
last_name varchar(100),
email varchar(150) unique not null,
user_role_id int references user_roles(role_id)
);

create table if not exists user_roles(
role_id int primary key,
u_role varchar(10)
);

create table if not exists reimbursement(
id serial primary key,
amount int not null,
submitted timestamp default current_timestamp not null, --YYYY-MM-DD hh-mm-ss format
resolved timestamp,
description varchar(250),
-- receipt blob, binary large object, a string datatype
author int references users(user_id) not null,
resolver int references users(user_id),
status_id int references reimbursement_status(id) not null,
type_id int references reimbursement_type(id) not null
);

create table if not exists reimbursement_status(
id serial primary key, 
status varchar(10) not null -- APPROVE or DENY
);

create table if not exists reimbursement_type(
id int primary key, -- 1, 2, 3, 4
reim_type varchar(10) not null -- LODGING, TRAVEL, FOOD, OTHER
);

insert into user_roles(role_id, u_role) values (1, 'Manager');
insert into user_roles(role_id, u_role) values (2, 'Employee');

insert into users (username, password, first_name, last_name, email, user_role_id) values ('Asanchez', 'pass', 'Angel', 'Sanchez', 'sancheza4@mail.com', 1);
insert into users (username, password, first_name, last_name, email, user_role_id) values ('mrosenbaum0', 'fMf4wRj', 'Melisandra', 'Rosenbaum', 'mrosenbaum0@yahoo.co.jp', 1);
insert into users (username, password, first_name, last_name, email, user_role_id) values ('nvick1', '4nh0wbFawa', 'Napoleon', 'Vick', 'nvick1@parallels.com', 1);
insert into users (username, password, first_name, last_name, email, user_role_id) values ('hsorby2', 'LA6XCklzysTK', 'Hubie', 'Sorby', 'hsorby2@ucoz.ru', 2);
insert into users (username, password, first_name, last_name, email, user_role_id) values ('efarncomb3', 'SPcuj8', 'Enid', 'Farncomb', 'efarncomb3@jimdo.com', 2);
insert into users (username, password, first_name, last_name, email, user_role_id) values ('wboast4', 'nx7NLziWn', 'Winnie', 'Boast', 'wboast4@instagram.com', 1);

insert into reimbursement_type(id, reim_type) values (1, 'LODGING');
insert into reimbursement_type(id, reim_type) values (2, 'TRAVEL');
insert into reimbursement_type(id, reim_type) values (3, 'FOOD');
insert into reimbursement_type(id, reim_type) values (4, 'OTHER');

insert into reimbursement_status(status) values ('Approved');
insert into reimbursement_status(status) values ('Denied');
insert into reimbursement_status(status) values ('Pending');

insert into reimbursement (amount, description, author, status_id, type_id) values (703, 'Unsp mtrcy rider inj in clsn w 2/3-whl mv in traf, sequela', 2, 2, 4);
insert into reimbursement (amount, description, author, status_id, type_id) values (323, 'Recurrent acute iridocyclitis', 2, 3, 2);
insert into reimbursement (amount, description, author, status_id, type_id) values (814, 'Injury of cauda equina, subsequent encounter', 3, 1, 4);
insert into reimbursement (amount, description, author, status_id, type_id) values (334, 'Adult failure to thrive', 2, 3, 3);
insert into reimbursement (amount, description, author, status_id, type_id) values (619, 'Toxic effect of contact w venomous toad, acc, sequela', 4, 1, 2);