create table member
(
    id int auto_increment primary key,
    email    varchar(100) null,
    password varchar(100) null,
    username varchar(100) null,
    unique (email),
    unique (username)
);

create table board
(
    id int auto_increment primary key,
    content     text         null,
    create_date datetime(6)  null,
    title     varchar(200) null,
    member_id   int       null,
    foreign key (member_id) references member (id)
);

create table comment
(
    id int auto_increment primary key,
    content     text        null,
    create_date datetime(6) null,
    member_id   int      null,
    board_id int         null,
    foreign key (member_id) references member (id),
    foreign key (board_id) references board (id)
);



