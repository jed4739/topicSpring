CREATE TABLE `member` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `email` varchar(100),
  `password` varchar(100),
  `username` varchar(100)
);

CREATE TABLE `board` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `content` text,
  `create_date` datetime(6),
  `title` varchar(200),
  `member_id` int
);

CREATE TABLE `comment` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `content` text,
  `create_date` datetime(6),
  `member_id` int,
  `board_id` int
);

ALTER TABLE `board` ADD FOREIGN KEY (`member_id`) REFERENCES `member` (`id`);

ALTER TABLE `comment` ADD FOREIGN KEY (`member_id`) REFERENCES `member` (`id`);

ALTER TABLE `comment` ADD FOREIGN KEY (`board_id`) REFERENCES `board` (`id`);
