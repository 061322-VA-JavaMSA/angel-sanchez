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
amount int,
submitted timestamp, --YYYY-MM-DD hh-mm-ss format
resolved timestamp,
description varchar(250),
-- receipt blob, binary large object, a string datatype
author int references users(user_id),
resolver int references users(user_id),
status_id int references reimbursement_status(id),
type_id int references reimbursement_type(id)
);

create table if not exists reimbursement_status(
id int primary key, 
status varchar(10) default 'pending' -- APPROVE or DENY
);

create table if not exists reimbursement_type(
id int primary key, -- 1, 2, 3, 4
reim_type varchar(10) -- LODGING, TRAVEL, FOOD, OTHER
);

insert into user_roles(role_id, u_role) values (1, 'Manager');
insert into user_roles(role_id, u_role) values (2, 'Employee');

insert into users(username, password, first_name, last_name, email, user_role_id) values ('Asanchez', 'pass', 'Angel', 'Sanchez', 'sancheza4@mail.com', 1);
insert into users(username, password, first_name, last_name, email, user_role_id) values ('H0mer', 'D0H', 'Homer', 'Simpson', 'SimpsHomer0@mail.com', 2);

insert into reimbursement_type(id, reim_type) values (1, 'LODGING');
insert into reimbursement_type(id, reim_type) values (2, 'TRAVEL');
insert into reimbursement_type(id, reim_type) values (3, 'FOOD');
insert into reimbursement_type(id, reim_type) values (4, 'OTHER');

insert into reimbursement(amount, description, author, type_id) values (1000, 'Ilios trip', 1, 2);

insert into reimbursement_status(id, status) values (1, 'Approved');
insert into reimbursement_status(id, status) values (2, 'Denied');


delete from reimbursement;
delete from reimbursement_status;

drop table reimbursement_status; 
drop table reimbursement;
