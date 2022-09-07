# Week 2 Review Guide
## SQL
1.	Explain what SQL is. What are some SQL databases?
2.	Draw a simple ERD for modelling Students and Classes
3.	What are the 5 sublanguages of SQL? Which commands correspond to them?
4.	What is the difference between DELETE, DROP, and TRUNCATE commands?
5.	What are some SQL clauses you can use with SELECT statements?
6.	What is the difference between WHERE and HAVING?
7.	Explain what the ORDER BY and GROUP BY clauses do
8.	Explain the concept of relational integrity
9.	List the integrity constraints
10.	Define the word “schema”
11.	What is a candidate key?
12.	What conditions lead to orphan records?
13.	What are some SQL data types?
14.	What is normalization? What are the levels?
15.	What are the properties a transaction must follow?
16.	Explain the different isolation levels. What read phenomena do each prevent?
17.	What is the difference between joins and set operators?
18.	What are the types of joins? Explain the differences.
19.	Explain the difference between UNION, UNION ALL, and INTERSECT
20.	What is a cascade delete?
21.	What is the purpose of a view? What about an index?
22.	How would you setup a primary key that automatically increments with every INSERT statement?
23.	What is the difference between scalar and aggregate functions? Give examples of each

Be familiar with the syntax for DDL and DML/DQL queries.
	- you may be asked to write a join/ a select statement using an aggregate function.

### Practicals

Given the following table 'employees'...

| id | firstName | lastName | salary | dept |
| --- | -------- | -------- | ------ | ---- |
| 1  | Michael   | Scott    | 65     | Sales|
| 2  | Dwight    | Schrute  | 75     | Sales|
| 3  | Toby      | Flenderson| 80    | HR  |
| 4  | Jim       | Halpert  | 90     | Sales|
| 5  | Oscar     | Martinez | 90     | Accounting |
| 6  | Angela    | Martin   | 75     | Accounting |
| 7  | Kevin     | Malone   | 70     | Accounting |
| 8  | Holly     | Flax     | 60     | HR |
| 9  | Creed     | Branton  | 70     | Quality Assurance |

* Write a query to find all data in the table

* Write a query to find employees with a salary over 75

* Write a query to find employees whose first name contains an 'e' or whose last name begins with 'S'\

* Write a query to find the first name of all employees who do not work in accounting

* Write a query to find the average salary of all employees whose last names begin with 'M'

* Write a query to find the highest paid salesperson

* Write a query to combine the resultsets of any two previous queries

* Remove all members of accounting from the database


* Given removing the dept column from the employees table and creating a table 'department' and linking the two via a foreign key relationship

| dept_id | name |
| ------- | ---  |
| 1       | Sales |
| 2       | HR   |
| 3       | Accounting |
| 4       | Customer Service |

* Write a query to find the salary of the lowest paid salesperson (HINT: use a join)

* Write a query to find the average salary of each department

* Write a query to find all possible combinations of employees and departments. How many records do you expect?

* Change the name of department 4 to 'Quality Assurance'

* Remove both tables

## JDBC
1.	What is JDBC?
2.	What are the core interfaces / classes in JDBC?
3.	What is a stored procedure and how would you call it in Java?
4.	What is the difference between Statement and PreparedStatement?
5.	Steps to executing an SQL query using JDBC?

## Design Patterns
1. What is the DAO design pattern?
2. What is the Singleton design pattern?
3. What is the Factory design pattern?

## Logging
1.	What are the advantages to using a logging library?
2.	What is logging?
3.	What are the different logging levels?