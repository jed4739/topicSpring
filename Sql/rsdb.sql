create table member
(
    id bigint(20) unsigned auto_increment primary key,
    email varchar(255) not null,
    password varchar(255) not null,
    username varchar(255) not null,
    unique (email),
    unique (username)
);

create table board
(
    id bigint(20) unsigned auto_increment primary key,
    member_id int not null,
    title varchar(255) not null,
    content text not null,
    create_date datetime not null,
    foreign key (member_id) references member (id)
);

create table comment
(
    id bigint(20) unsigned auto_increment primary key,
    member_id int not null,
    board_id int not null,
    content text not null,
    create_date datetime not null,
    foreign key (member_id) references member (id),
    foreign key (board_id) references board (id)
);



