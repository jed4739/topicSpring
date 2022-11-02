SET SESSION FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS member;
CREATE TABLE member
(
	id int NOT NULL AUTO_INCREMENT COMMENT '아이디',
	email varchar(50) NOT NULL COMMENT '이메일',
	password varchar(100) NOT NULL COMMENT '비밀번호',
	name varchar(15) NOT NULL COMMENT '이름',
	created datetime NOT NULL COMMENT '가입일',
	PRIMARY KEY (id),
	UNIQUE (email)
) COMMENT = '멤버';



