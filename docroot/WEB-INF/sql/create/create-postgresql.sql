drop database lportal;
create database lportal encoding = 'UNICODE';
\c lportal;

create table GB_Entry (
	uuid_ varchar(75) null,
	entryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(75) null,
	email varchar(75) null,
	message varchar(75) null,
	guestbookId bigint
);

create table GB_Guestbook (
	uuid_ varchar(75) null,
	guestbookId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(75) null
);


create index IX_F5591FB6 on GB_Entry (groupId, guestbookId);
create index IX_3BD8D300 on GB_Entry (uuid_);
create index IX_B5EF5128 on GB_Entry (uuid_, companyId);
create unique index IX_C1EA01AA on GB_Entry (uuid_, groupId);

create index IX_9294AD47 on GB_Guestbook (groupId);
create index IX_ABB2E591 on GB_Guestbook (uuid_);
create index IX_9314A9F7 on GB_Guestbook (uuid_, companyId);
create unique index IX_EDD4239 on GB_Guestbook (uuid_, groupId);


