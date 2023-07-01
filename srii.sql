show databases;
create database srii;
show tables;
use srii;
create table employ(
e_id int primary key,
ename varchar(30),
sal int);

 insert into employ values(1,'sri',123);
update employ set sal=122 where e_id=1;
 select * from employ;
