create table if not exists customers(
customer_id int primary key,
CusFirst_name varchar(256),
CusLast_name varchar(256),
customer_age int,
dob date
);

create table if not exists sales_person(
employee_id serial primary key,
first_name varchar(50),
last_name varchar(50),
email varchar(50),
ciy varchar(50),
zip_code int
);

create table if not exists sales_office(
street varchar(356),
city varchar(50),
state varchar(50),
zip_code int
);