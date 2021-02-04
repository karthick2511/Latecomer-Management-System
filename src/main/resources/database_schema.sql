create table users
(
    user_name varchar(225) not null unique primary key,
    password  varchar(225) not null,
    user_role varchar(125) not null
);

insert into users (user_name, password, user_role)
values ('admin', 'admin', 'admin');

create table master
(
    register_number      varchar(255) not null,
    date_of_record       DATE         not null,
    in_time              TIME         not null,
    coordinate_staffName varchar(255) not null,
    description          varchar(255) not null

);

create table student
(
    register_number varchar(225) not null unique primary key,
    student_name    varchar(225) not null,
    department      varchar(125) not null,
    mail_id         varchar(225) not null,
    address         varchar(225) not null,
    mobile_number   long         not null,
    dob             DATE         not null,
    user_role       varChar(125) default 'student'
);

create table staff
(
    staff_iD      varchar(225) not null unique primary key,
    staff_name    varchar(225) not null,
    password      varchar(125) not null,
    mail_id       varchar(225) not null,
    address       varchar(225) not null,
    mobile_number long         not null,
    dob           DATE         not null,
    user_role     varchar(125) default 'staff'
);