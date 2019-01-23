CREATE TABLE salesperson (
    id INT,
    first_name VARCHAR(20),
    age INT,
    salary INT);

INSERT INTO salesperson (id, first_name, age, salary)
    VALUES
	(1,  'Abe',   61, 140000),
	(2,  'Bob',   34,  44000),
	(5,  'Chris', 34,  40000),
	(7,  'Dan',   41,  52000),
	(8,  'Ken',   61, 115000),
	(11, 'Joe',   61,  38000);

CREATE TABLE customer (
    id INT,
    customer_name VARCHAR(20),
    city VARCHAR(20),
    industry_type VARCHAR(2));

INSERT INTO customer (id, customer_name, city, industry_type) 
    VALUES
	(4,  'Samsonic', 'pleasant', 'J'),
	(6,  'Pansung',  'oaktown',  'J'),
	(7,  'Samony',   'jackson',  'B'),
	(9,  'Orange',   'Jackson',  'B');

SHOW TABLES;

SELECT * FROM salesperson;
SELECT * FROM customer;
