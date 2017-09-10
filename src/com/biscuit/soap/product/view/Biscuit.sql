Enter password: ****
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 12
Server version: 5.5.18 MySQL Community Server (GPL)

Copyright (c) 2000, 2011, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> use springboot;
Database changed
mysql> show tables;
+----------------------+
| Tables_in_springboot |
+----------------------+
| employee             |
| product              |
+----------------------+
3 rows in set (0.00 sec)

mysql> CREATE TABLE biscuit
    -> (
    -> ID int(11) NOT NULL AUTO_INCREMENT,
    -> BiscuitName varchar(75),
    -> BiscuitType varchar(75) NOT NULL,
    -> BiscuitStock varchar(55),
    -> BiscuitBrand varchar(55),
    -> PRIMARY KEY (ID)
    -> );
Query OK, 0 rows affected (0.16 sec)

mysql> desc biscuit;
+--------------+-------------+------+-----+---------+----------------+
| Field        | Type        | Null | Key | Default | Extra          |
+--------------+-------------+------+-----+---------+----------------+
| ID           | int(11)     | NO   | PRI | NULL    | auto_increment |
| BiscuitName  | varchar(75) | YES  |     | NULL    |                |
| BiscuitType  | varchar(75) | NO   |     | NULL    |                |
| BiscuitStock | varchar(55) | YES  |     | NULL    |                |
| BiscuitBrand | varchar(55) | YES  |     | NULL    |                |
+--------------+-------------+------+-----+---------+----------------+
5 rows in set (0.05 sec)

mysql> insert into biscuit(BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand)
 values ("Parle", "Basic", "Yes", "EverGreen");
Query OK, 1 row affected (0.02 sec)

mysql> insert into biscuit(BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand)
 values ("Parle", "Pineapple", "Yes", "Seasonal");
Query OK, 1 row affected (0.02 sec)

mysql> insert into biscuit(BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand)
 values ("Britania", "Basic", "NA", "EverGreen");
Query OK, 1 row affected (0.02 sec)

mysql> insert into biscuit(BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand)
 values ("CrackJack", "Awesome", "Yes", "EverGreen");
Query OK, 1 row affected (0.01 sec)

mysql> insert into biscuit(BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand)
 values ("SunFeast", "Basic", "Yes", "So So");
Query OK, 1 row affected (0.03 sec)

mysql> select * from biscuit;
+----+-------------+-------------+--------------+--------------+
| ID | BiscuitName | BiscuitType | BiscuitStock | BiscuitBrand |
+----+-------------+-------------+--------------+--------------+
|  1 | Parle       | Basic       | Yes          | EverGreen    |
|  2 | Parle       | Pineapple   | Yes          | Seasonal     |
|  3 | Britania    | Basic       | NA           | EverGreen    |
|  4 | CrackJack   | Awesome     | Yes          | EverGreen    |
|  5 | SunFeast    | Basic       | Yes          | So So        |
+----+-------------+-------------+--------------+--------------+
5 rows in set (0.00 sec)

mysql> insert into biscuit(BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand)
 values ("Britannia", "Blue", "Yes", "Seasonal");
Query OK, 1 row affected (0.03 sec)

mysql> insert into biscuit(BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand)
 values ("Britannia", "Purple", "Yes", "Seasonal");
Query OK, 1 row affected (0.02 sec)

mysql> insert into biscuit(BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand)
 values ("Priya Gold", "Basic", "NA", "EverGreen");
Query OK, 1 row affected (0.01 sec)

mysql> insert into biscuit(BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand)
 values ("Priya Gold", "Awesome", "Yes", "Seasonal");
Query OK, 1 row affected (0.01 sec)

mysql> insert into biscuit(BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand)
 values ("Anmol", "Basic", "Yes", "So So");
Query OK, 1 row affected (0.01 sec)

mysql> insert into biscuit(BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand)
 values ("Anmol", "Cremica", "Yes", "EverGreen");
Query OK, 1 row affected (0.02 sec)

mysql> insert into biscuit(BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand)
 values ("Horlicks", "Basic", "No", "So So");
Query OK, 1 row affected (0.01 sec)

mysql> insert into biscuit(BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand)
 values ("Horlicks", "Basic", "Yes", "EverGreen");
Query OK, 1 row affected (0.01 sec)

mysql> insert into biscuit(BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand)
 values ("Dukes", "Basic", "Yes", "Seasonal");
Query OK, 1 row affected (0.01 sec)

mysql> insert into biscuit(BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand)
 values ("Dukes", "Basic", "Yes", "So So");
Query OK, 1 row affected (0.18 sec)

mysql> select * from biscuit;
+----+-------------+-------------+--------------+--------------+
| ID | BiscuitName | BiscuitType | BiscuitStock | BiscuitBrand |
+----+-------------+-------------+--------------+--------------+
|  1 | Parle       | Basic       | Yes          | EverGreen    |
|  2 | Parle       | Pineapple   | Yes          | Seasonal     |
|  3 | Britania    | Basic       | NA           | EverGreen    |
|  4 | CrackJack   | Awesome     | Yes          | EverGreen    |
|  5 | SunFeast    | Basic       | Yes          | So So        |
|  6 | Britannia   | Blue        | Yes          | Seasonal     |
|  7 | Britannia   | Purple      | Yes          | Seasonal     |
|  8 | Priya Gold  | Basic       | NA           | EverGreen    |
|  9 | Priya Gold  | Awesome     | Yes          | Seasonal     |
| 10 | Anmol       | Basic       | Yes          | So So        |
| 11 | Anmol       | Cremica     | Yes          | EverGreen    |
| 12 | Horlicks    | Basic       | No           | So So        |
| 13 | Horlicks    | Basic       | Yes          | EverGreen    |
| 14 | Dukes       | Basic       | Yes          | Seasonal     |
| 15 | Dukes       | Basic       | Yes          | So So        |
+----+-------------+-------------+--------------+--------------+
15 rows in set (0.00 sec)

mysql>
