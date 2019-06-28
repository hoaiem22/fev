use fptueventclub;

drop table if exists fev_account;
drop table if exists fev_account_role;
drop table if exists fev_member_position;
drop table if exists fev_member_status;
drop table if exists fev_member_group;
drop table if exists fev_member;
drop table if exists fev_event;
drop table if exists fev_event_member;
drop table if exists fev_event_album;
drop table if exists fev_feedback_status;
drop table if exists fev_feedback;
drop table if exists fev_transaction_type;
drop table if exists fev_transaction;
drop table if exists fev_inventory_status;
drop table if exists fev_inventory_item;
drop table if exists fev_inventory;
drop table if exists fev_member_group;
drop table if exists fev_vote_key;
drop table if exists fev_vote;
drop table if exists fev_vote_candidate;


create table fev_account_role (
	id int auto_increment not null,
    role varchar(255) not null,
    note varchar(255),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id)
);

create table fev_account (
	id int auto_increment not null,
    username varchar(255) not null,
    password varchar(255) not null,
    role int not null,
    note varchar(255),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id),
    foreign key (role) references fev_account_role(id)
);

-- Planning, Implement, PR, Finance, HR
create table fev_member_position (
	id int auto_increment not null,
    `position` varchar (255) not null,
    note varchar(255),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id)
);

-- Working, Reserve
create table fev_member_status (
	id int auto_increment not null,
    `status` varchar(50) not null,
    note varchar(255),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id)
);

create table fev_member_group (
	id int auto_increment not null,
    `group` varchar (255) not null,
    note varchar(255),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id)
);

create table fev_member (
	id int auto_increment not null,
    fullname varchar(50) CHARACTER SET utf8,
    studentID varchar(50) CHARACTER SET utf8 not null,
    birthdate date,
    k varchar(50) CHARACTER SET utf8,
    email varchar(250) CHARACTER SET utf8,
    facebook varchar(250) CHARACTER SET utf8,
    img varchar(5000) CHARACTER SET utf8,
    sex varchar(10) CHARACTER SET utf8,
    address varchar(50) CHARACTER SET utf8,
    phone varchar(50) CHARACTER SET utf8,
    `position` int not null,
    `group` int not null,
    `status` int not null,
    `point` int,
    constraint noduplicate unique (studentID),
	note varchar(255) CHARACTER SET utf8,
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id),
    foreign key (`position`) references fev_member_position(id),
    foreign key (`status`) references fev_member_status(id),
    foreign key (`group`) references fev_member_group(id)
);


create table fev_event (
	id int auto_increment not null,
    name varchar(50),
    `start` datetime,
    `end` datetime,
    `time` datetime,
    place varchar(250),    
    leader int not null,
    note varchar(255),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key(id),
    foreign key (leader) references fev_member(id)
);

create table fev_event_member (
	id int auto_increment not null,
    `event` int,
    member int,
    note varchar(255),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key(id),
    foreign key (member) references fev_member(id),
    foreign key ( `event`) references fev_event(id),
    constraint noduplicate unique (`event`, `member` )
);

create table fev_event_album (
	id int auto_increment not null,
    `event` int not null,
    img varchar(250), -- Link to img
    note varchar(255),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id),
    foreign key (`event`) references fev_event(id)
);

create table fev_feedback_status (
	id int auto_increment not null,
    status varchar(250) not null, -- Read, Draft, Reviewing, . . .
    note varchar(250),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id)
);

create table fev_feedback (
	id int auto_increment not null,
    sender varchar(50), -- From person who send feedback, they should leave their contact (email, phone or fullname) if they need the answer
    content varchar(5000),
    `status` int not null, -- Read, Draft, Reviewing, . . .
    note varchar(250),
    primary key (id),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    foreign key (`status`) references fev_feedback_status(id)
);

create table fev_transaction_type (
	id int auto_increment not null,
    `type` varchar (50), -- withdraw, pay
    note varchar(50),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id)
);

create table fev_transaction (
	id int auto_increment not null,
    `type` int not null, -- withdraw, 
    content varchar(50),
    money int,
    `event` int, -- from event (if need)
    burden int not null, -- MemberID who withdraw or . . .
    note varchar(50),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id),
    foreign key (`event`) references fev_event(id),
    foreign key (`burden`) references fev_member(id),
    foreign key (`type`) references fev_transaction_type(id)
);

create table fev_inventory_status (
	id int auto_increment not null,
    `status` varchar(250), -- borrowed, free
    note varchar(250),                                                                                                                                                                   
    primary key (id)
);

create table fev_inventory_item (
	id int auto_increment not null,
	`name` varchar(250),
    address varchar(250),
    price varchar(50),
    note varchar(250),              
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id)
);

create table fev_inventory (
	id int auto_increment not null,
    item int,
    quantity int,
    holder int not null, -- The member who hold item
    `status` int not null, -- Free, borrowed
    note varchar(250),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id),
    foreign key (holder) references fev_member(id),
    foreign key (`status`) references fev_inventory_status(id),
    foreign key (item) references fev_inventory_item(id)
);

create table fev_vote_key(
	id int auto_increment not null,
    `key` varchar(250) not null,
    priority int not null,
    isActive bit(1) not null,
    note varchar(250),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id)
);

create table fev_vote(
	id int auto_increment not null,
    candidatetime int not null,
    `key` int not null,
    note varchar(250),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id),
    foreign key (candidatetime) references fev_member(id),
    foreign key (`key`) references fev_vote_key(id)
);

create table fev_vote_term(
	id int auto_increment not null,
    name varchar(50),
    term varchar(50),
    `year` varchar(10),
    note varchar(250),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id)
);

create table fev_vote_candidate(
	id int auto_increment not null,
    member int not null,
    term int not null,
    `position` int not null,
    `group` int not null,
    total int,
    quote varchar(5000),
    note varchar(250),
    created datetime,
    createdby_username varchar(50), -- user who create report
    lastmodified datetime, 
    lastmodifiedby_username varchar(50), 
    primary key (id),
    foreign key (member) references fev_member(id),
    foreign key (`position`) references fev_member_position(id),
    foreign key (`group`) references fev_member_group(id),
    foreign key (term) references fev_vote_term(id)
);



