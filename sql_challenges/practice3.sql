-- Given the tables above, find the following:
-- 1. The names of all salespeople that have an order with Samsonic.
SELECT
	s.first_name
FROM
	salesperson s, orders o, customer c
WHERE
	s.id = o.salesperson_id AND
    o.cust_id = c.id AND
    c.customer_name = 'Samsonic';

-- 2. The names of all salespeople that do not have any order with Samsonic.
SELECT
	s.first_name
FROM
	salesperson s
WHERE
	s.id NOT IN (
    SELECT 
		s2.id
	FROM
		salesperson s2, customer c2, orders o2
    WHERE
		s2.id = o2.salesperson_id AND
        o2.cust_id = c2.id AND
        c2.customer_name = 'Samsonic');

-- 3. The names of salespeople that have 2 or more orders.
SELECT
	MAX(s.first_name) AS first_name
FROM
	salesperson s, orders o
WHERE
	s.id = o.salesperson_id
GROUP BY
	o.salesperson_id
HAVING
	COUNT(o.order_number) >= 2;

-- 4. The names and ages of all salespersons must having a salary of 100,000 or greater.
SELECT
	s.first_name, s.age
FROM
	salesperson s
WHERE
	s.salary >= 100000;
