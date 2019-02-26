CREATE SCHEMA practice;
use practice;
SHOW tables;

CREATE TABLE t1 (
    id INT PRIMARY KEY,
    pattern VARCHAR(50) NOT NULL
);
 
CREATE TABLE t2 (
    id VARCHAR(50) PRIMARY KEY,
    pattern VARCHAR(50) NOT NULL
);

SHOW tables;

INSERT INTO t1(id, pattern)
VALUES(1,'Divot'),
      (2,'Brick'),
      (3,'Grid');
 
INSERT INTO t2(id, pattern)
VALUES('A','Brick'),
      ('B','Grid'),
      ('C','Diamond');


SELECT 
    t1.id, t2.id
FROM
    t1
CROSS JOIN t2;

SELECT 
    t1.id, t2.id
FROM
    t1
        INNER JOIN
    t2 ON t1.pattern = t2.pattern;

SELECT 
    t1.id, t2.id
FROM
    t1
        LEFT JOIN
    t2 ON t1.pattern = t2.pattern
ORDER BY t1.id;

SELECT 
    t1.id, t2.id
FROM
    t1
        RIGHT JOIN
    t2 on t1.pattern = t2.pattern
ORDER BY t2.id;
