drop table if exists MEMBER;

create table MEMBER (
	ID int auto_increment primary key,    
    EMAIL varchar(50) not null unique,
    PASSWORD varchar(20) not null,
    NAME varchar(20) not null,
    REGDATE timestamp not null
);
