create table GB_Entry (
	uuid_ VARCHAR2(75 CHAR) null,
	entryId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name VARCHAR2(75 CHAR) null,
	email VARCHAR2(75 CHAR) null,
	message VARCHAR2(75 CHAR) null,
	guestbookId number(30,0)
);

create table GB_Guestbook (
	uuid_ VARCHAR2(75 CHAR) null,
	guestbookId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name VARCHAR2(75 CHAR) null
);
