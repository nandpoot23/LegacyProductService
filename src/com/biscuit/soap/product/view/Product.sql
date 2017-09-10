Enter password: ****
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 11
Server version: 5.5.18 MySQL Community Server (GPL)

Copyright (c) 2000, 2011, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| springboot         |
| springcustomer     |
| test               |
| testemp            |
+--------------------+
7 rows in set (0.13 sec)

mysql> use springboot;
Database changed

mysql> CREATE TABLE product
    -> (
    -> ID int(11) NOT NULL AUTO_INCREMENT,
    -> ProductName varchar(75),
    -> ProductType varchar(75) NOT NULL,
    -> ProductValue varchar(55),
    -> MarketValue varchar(55),
    -> PRIMARY KEY (ID)
    -> );
Query OK, 0 rows affected (0.24 sec)

mysql> desc product;
+--------------+-------------+------+-----+---------+----------------+
| Field        | Type        | Null | Key | Default | Extra          |
+--------------+-------------+------+-----+---------+----------------+
| ID           | int(11)     | NO   | PRI | NULL    | auto_increment |
| ProductName  | varchar(75) | YES  |     | NULL    |                |
| ProductType  | varchar(75) | NO   |     | NULL    |                |
| ProductValue | varchar(55) | YES  |     | NULL    |                |
| MarketValue  | varchar(55) | YES  |     | NULL    |                |
+--------------+-------------+------+-----+---------+----------------+
5 rows in set (0.03 sec)

mysql> insert into product(ProductName, ProductType, ProductValue, MarketValue)
    -> values ("P1", "T1", "55K", "75K");
Query OK, 1 row affected (0.03 sec)

mysql> select * from product;
+----+-------------+-------------+--------------+-------------+
| ID | ProductName | ProductType | ProductValue | MarketValue |
+----+-------------+-------------+--------------+-------------+
|  1 | P1          | T1          | 55K          | 75K         |
+----+-------------+-------------+--------------+-------------+
1 row in set (0.00 sec)

mysql> insert into product(ProductName, ProductType, ProductValue, MarketValue)
    -> values ("P2", "T2", "80K", "108K");
Query OK, 1 row affected (0.04 sec)

mysql> insert into product(ProductName, ProductType, ProductValue, MarketValue)
    -> values ("P3", "T3", "90K", "125K");
Query OK, 1 row affected (0.02 sec)

mysql> insert into product(ProductName, ProductType, ProductValue, MarketValue)
    -> values ("P4", "T4", "108K", "155K");
Query OK, 1 row affected (0.03 sec)

mysql> insert into product(ProductName, ProductType, ProductValue, MarketValue)
    -> values ("P5", "T5", "155K", "275K");
Query OK, 1 row affected (0.09 sec)

mysql> select * from product;
+----+-------------+-------------+--------------+-------------+
| ID | ProductName | ProductType | ProductValue | MarketValue |
+----+-------------+-------------+--------------+-------------+
|  1 | P1          | T1          | 55K          | 75K         |
|  2 | P2          | T2          | 80K          | 108K        |
|  3 | P3          | T3          | 90K          | 125K        |
|  4 | P4          | T4          | 108K         | 155K        |
|  5 | P5          | T5          | 155K         | 275K        |
+----+-------------+-------------+--------------+-------------+
5 rows in set (0.00 sec)

mysql>
