create table GB_Entry (
	uuid_ varchar(75) null,
	entryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	name varchar(75) null,
	email varchar(75) null,
	message varchar(75) null,
	guestbookId bigint
) engine InnoDB;

create table GB_Guestbook (
	uuid_ varchar(75) null,
	guestbookId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	name varchar(75) null
) engine InnoDB;
