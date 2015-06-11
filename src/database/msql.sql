create database stu;
use stu;
create table students(id integer,name varchar(20));
insert into students values('517','sindhusha');
create table questions(id integer,que varchar(100),opt1 varchar(100),opt2 varchar(100),opt3 varchar(100),opt4 varchar(100),topic varchar(40),ans integer);
insert into questions values('1',' a=5, b=4  then a+b=?','2','5','4','9','Compiler Design','4');
insert into questions values('1','difference between == and === ?','both are type conversion comparison operators','== is strict comparison and === is type converting comparison operators','=== is strict comparison and == is type converting comparison operators','none','Programming Languages','3');
insert into questions values('2','push and pop belongs to?','lists','arrays','stacks','queues','Compiler Design','3');
 
