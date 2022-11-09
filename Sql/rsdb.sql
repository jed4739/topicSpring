create table member
(
    id int auto_increment primary key,
    email varchar(255) not null,
    password varchar(255) not null,
    username varchar(255) not null,
    unique (email),
    unique (username)
);

create table board
(
    id int auto_increment primary key,
    content text not null,
    create_date datetime not null,
    title varchar(255) not null,
    member_id int not null,
    foreign key (member_id) references member (id)
);

create table comment
(
    id int auto_increment primary key,
    content text not null,
    create_date datetime not null,
    member_id int not null,
    board_id int not null,
    foreign key (member_id) references member (id),
    foreign key (board_id) references board (id)
);



