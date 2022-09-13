-- Book table.
DROP TABLE IF EXISTS ocbc_book;
CREATE TABLE ocbc_book
(
    id          int(10) unsigned NOT NULL AUTO_INCREMENT,
    title       varchar(512)     NOT NULL,
    author      varchar(32)      NOT NULL DEFAULT 'ocbc' COMMENT 'COMPANY ocbc，PERSON username',
    summary     varchar(2048)             DEFAULT NULL,
    image       varchar(256)              DEFAULT NULL COMMENT 'Path of image',
    create_time datetime(3)      NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    update_time datetime(3)      NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
    delete_time datetime(3)               DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

-- Test data.
INSERT INTO ocbc_book.ocbc_book (id, title, author, summary, image, create_time, update_time, delete_time) VALUES (1, 'Core Java Volume 2 - Advanced Feature', 'Cay S Horstmann', 'The Java SE 8 Stream Library and etc.', null, '2022-09-11 18:21:45', '2022-09-11 18:21:45', null);
INSERT INTO ocbc_book.ocbc_book (id, title, author, summary, image, create_time, update_time, delete_time) VALUES (2, '丘吉尔传', '安德鲁·罗伯茨', '在20世纪的英国历史中，丘吉尔是一座不可超越的丰碑', null, '2022-09-11 18:25:45', '2022-09-11 18:25:45', null);
INSERT INTO ocbc_book.ocbc_book (id, title, author, summary, image, create_time, update_time, delete_time) VALUES (3, '时间简史', '史蒂芬·霍金', '史蒂芬·霍金的《时间简史》自1988年首版以来的岁月里，已成为全球科学著作的里程碑。', null, '2022-09-11 21:30:45', '2022-09-11 21:30:45', '2022-09-11 21:35:45');

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS ocbc_user;
CREATE TABLE ocbc_user (
    id          int(10) unsigned NOT NULL AUTO_INCREMENT,
    openid      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    nickname    varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    unify_uid   int(10)     DEFAULT NULL,
    email       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    password    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    mobile      varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    wx_profile  json        DEFAULT NULL,
    create_time datetime(3) DEFAULT CURRENT_TIMESTAMP(3),
    update_time datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
    delete_time datetime(3) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY uni_openid (openid) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
