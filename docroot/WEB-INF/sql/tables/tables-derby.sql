create table GB_Entry (
	uuid_ varchar(75),
	entryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	name varchar(75),
	email varchar(75),
	message varchar(75),
	guestbookId bigint
);

create table GB_Guestbook (
	uuid_ varchar(75),
	guestbookId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	name varchar(75)
);
