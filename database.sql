
--  drop table trainer;
-- select * from trainer;
CREATE TABLE userLogin (
    user_id SERIAL primary key,
    email varchar(45) unique,
    pass varchar(13),
    user_type boolean
);

create table trainer(
	id_trainer serial primary key,
	first_name varchar(35),
	last_name varchar(35),
	phone varchar(35),
	pass_fail_rate int,
	user_id int,
	FOREIGN KEY (user_id) REFERENCES userlogin(user_id)
);

create table course (
	course_id serial primary key,
	start_date date,
	id_trainer int,
	FOREIGN KEY (id_trainer) REFERENCES trainer(id_trainer)
);

create table trainee(
	id_trainee serial primary key,
	tr_name varchar(35),
	age int,
	address varchar(35),
	course_id int,
	user_id int,
	FOREIGN KEY (user_id) REFERENCES userlogin(user_id),
	FOREIGN KEY (course_id) REFERENCES course(course_id)
);

create table vehicle(
	id_vehicle serial primary key,
	brand varchar(35),
	model varchar(35)
);

create table exam (
	id_exam serial primary key,
	exam_date date,
	exam_result boolean,
	id_trainee int,
	FOREIGN KEY (id_trainee) REFERENCES trainee(id_trainee)
);

insert into vehicle(brand, model)
values ('kawasaki','ninja'),
('honda','cbr'),('honda','rebel'),('yamaha','yzf');

insert into userLogin(email,pass,user_type) 
values ('vlad@yahoo.com','pass',false),
('gabi@yahoo.com','pass',true),
('gabi2@yahoo.com','pass',true),
('gabi3@yahoo.com','pass',true),
('elena@yahoo.com','pass',false);

insert into trainer(first_name, last_name, phone, pass_fail_rate, user_id)
values ('pop','gabi','074284344','85','2'),
('ana','mihai','074284344','32','3'),
('pop','george','074283244','56','4');

insert into course(start_date, id_trainer)
values ('10-10-2019','1'),('05-20-2019','1'),('10-03-2019','2'),
('09-24-2019','3'),('06-17-2019','2');

insert into trainee (tr_name, age, address, course_id, user_id)
values ('vlad','20','Str 1','1','1'),
('maria','22','Str 1','1','1'),
('elena','20','Str 1','2','5');


insert into exam(exam_date, exam_result, id_trainee)
values ('02-02-2019','false','1'),('03-10-2019','true','1');