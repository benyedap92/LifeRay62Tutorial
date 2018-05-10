create table GB_Entry (
	uuid_ nvarchar(75) null,
	entryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName nvarchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	name nvarchar(75) null,
	email nvarchar(75) null,
	message nvarchar(75) null,
	guestbookId bigint
);

create table GB_Guestbook (
	uuid_ nvarchar(75) null,
	guestbookId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName nvarchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	name nvarchar(75) null
);
