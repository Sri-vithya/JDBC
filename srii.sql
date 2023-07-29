create database busresv;
use busresv;
create table bus(
id int primary key,
ac boolean, capacity int);

insert into bus values(1,1,40);

select * from bus;

create table booking(
passenger_name varchar(50),
bus_no int,
travel_date date);
select * from booking;
