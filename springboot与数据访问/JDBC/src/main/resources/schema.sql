drop table if exists department;
drop table if exists employee;

create table department(
    id int primary key,
    departmentName varchar(10)
);

create table employee(
    id int primary key,
    lastName varchar(10),
    email varchar(30),
    gender int,
    departmentID int(10)
);

insert into department values('001', '研发部');
insert into department values('002', '销售部');
insert into department values('003', '人事部');
insert into department values('004', '后勤部');

insert into employee values('001', 'wu', 'wu@outlook.com', 0, '001');
insert into employee values('002', 'zhang', 'zhang@outlook.com', 1, '003');
insert into employee values('003', 'li', 'li@outlook.com', 1, '002');