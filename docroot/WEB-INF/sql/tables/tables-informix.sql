create table GB_Entry (
	uuid_ varchar(75),
	entryId int8 not null primary key,
	groupId int8,
	companyId int8,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	name varchar(75),
	email varchar(75),
	message varchar(75),
	guestbookId int8
)
extent size 16 next size 16
lock mode row;

create table GB_Guestbook (
	uuid_ varchar(75),
	guestbookId int8 not null primary key,
	groupId int8,
	companyId int8,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	name varchar(75)
)
extent size 16 next size 16
lock mode row;
