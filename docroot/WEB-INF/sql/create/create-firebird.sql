create database 'lportal.gdb' page_size 8192 user 'sysdba' password 'masterkey';
connect 'lportal.gdb' user 'sysdba' password 'masterkey';
create table GB_Entry (uuid_ varchar(75),entryId int64 not null primary key,groupId int64,companyId int64,userId int64,userName varchar(75),createDate timestamp,modifiedDate timestamp,name varchar(75),email varchar(75),message varchar(75),guestbookId int64);
create table GB_Guestbook (uuid_ varchar(75),guestbookId int64 not null primary key,groupId int64,companyId int64,userId int64,userName varchar(75),createDate timestamp,modifiedDate timestamp,name varchar(75));
