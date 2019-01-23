CREATE DATABASE practice;

USE practice;

-- salesperson:
DROP TABLE salesperson;

CREATE TABLE IF NOT EXISTS salesperson(
    id INT,
    first_name VARCHAR(20),
    age INT, 
    salary INT);

INSERT INTO salesperson(id, first_name, age, salary) VALUES
	(1,  'Abe',   61, 140000),
	(2,  'Bob',   34,  44000),
	(5,  'Chris', 34,  40000),
	(7,  'Dan',   41,  52000),
	(8,  'Ken',   57, 115000),
	(11, 'Joe',   61,  38000);

-- customer:
CREATE TABLE IF NOT EXISTS customer (
    id INT, 
    customer_name VARCHAR(20),
    city VARCHAR(20), 
    industry_type VARCHAR(2));

INSERT INTO customer (id, customer_name, city, industry_type) VALUES
	(4,  'Samsonic', 'pleasant', 'J'),
	(6,  'Pansung',  'oaktown',  'J'),
	(7,  'Samony',   'jackson',  'B'),
	(9,  'Orange',   'Jackson',  'B');

-- orders:
CREATE TABLE IF NOT EXISTS orders (
    order_number INT,
    order_date DATE,
	cust_id INT,
    salesperson_id INT,
    amount INT);

INSERT INTO orders (order_number, order_date, cust_id, salesperson_id, amount) VALUES
    (10, '1996-02-08', 4, 2,  540),
    (20, '1999-01-30', 4, 8, 1800),
    (30, '1995-07-14', 9, 1,  460),
    (40, '1998-01-29', 7, 2, 2400),
    (50, '1998-02-03', 6, 7,  600),
    (60, '1998-03-02', 6, 7,  720),
    (70, '1996-05-06', 9, 7,  150);

SHOW TABLES;

SELECT * FROM salesperson;
SELECT * FROM customer;
SELECT * FROM orders;

-- Given the tables above, find the following:
-- 1. The names of all salespeople that have an order with Samsonic.
SELECT s.first_name 
FROM
	salesperson s, customer c, orders o 
WHERE
	s.id = o.salesperson_id AND
	c.id = o.cust_id AND
	c.customer_name = 'Samsonic';

-- 2. The names of all salespeople that do not have any order with Samsonic.
SELECT s.first_name
FROM salesperson s
WHERE s.id NOT IN (
SELECT
	o.salesperson_id
FROM
	customer c, orders o 
WHERE
	c.id = o.cust_id AND
	c.customer_name = 'Samsonic');

-- 3. The names of salespeople that have 2 or more orders.
SELECT MAX(first_name)
FROM salesperson, orders
WHERE orders.salesperson_id = salesperson.id
GROUP BY salesperson_id
HAVING COUNT(salesperson_id) >= 2;

-- 4. The names and ages of all salespersons must having a salary of 100,000 or greater.
SELECT first_name, age
FROM salesperson s
WHERE salary >= 100000;
