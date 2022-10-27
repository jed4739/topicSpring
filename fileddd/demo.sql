SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS write_;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS topic;




/* Create Tables */

-- 저자
CREATE TABLE author
(
	id int NOT NULL AUTO_INCREMENT COMMENT '저자 식별 아이디',
	userid varchar(100) NOT NULL COMMENT '유저 아이디',
	mail varchar(100) NOT NULL COMMENT '이메일',
	user_password varchar(100) NOT NULL COMMENT '유저 비밀번호',
	name varchar(15) NOT NULL COMMENT '이름',
	created datetime NOT NULL COMMENT '가입일',
	role enum("User","Admin") NOT NULL COMMENT '권한',
	PRIMARY KEY (id),
	UNIQUE (userid),
	UNIQUE (mail)
) COMMENT = '저자';


-- 댓글
CREATE TABLE comment
(
	id int NOT NULL AUTO_INCREMENT COMMENT '댓글 아이디',
	description text NOT NULL COMMENT '본문',
	created datetime NOT NULL COMMENT '작성일',
	topic_id int NOT NULL COMMENT '글 아이디',
	author_id int NOT NULL COMMENT '저자 식별 아이디',
	PRIMARY KEY (id)
) COMMENT = '댓글';


-- topic
CREATE TABLE topic
(
	id int NOT NULL AUTO_INCREMENT COMMENT '글 아이디',
	title varchar(30) NOT NULL COMMENT '제목',
	description text NOT NULL COMMENT '본문',
	created datetime NOT NULL COMMENT '작성일',
	PRIMARY KEY (id)
) COMMENT = 'topic';


-- author와 topic 중간테이블
CREATE TABLE write_
(
	topic_id int NOT NULL COMMENT '글 아이디',
	author_id int NOT NULL COMMENT '저자 식별 아이디',
	created datetime NOT NULL COMMENT '작성일',
	PRIMARY KEY (topic_id, author_id)
) COMMENT = 'author와 topic 중간테이블';



/* Create Foreign Keys */

ALTER TABLE comment
	ADD FOREIGN KEY (author_id)
	REFERENCES author (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE write_
	ADD FOREIGN KEY (author_id)
	REFERENCES author (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE comment
	ADD FOREIGN KEY (topic_id)
	REFERENCES topic (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE write_
	ADD FOREIGN KEY (topic_id)
	REFERENCES topic (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



