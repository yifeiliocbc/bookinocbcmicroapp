DROP TABLE IF EXISTS ocbc_book;
CREATE TABLE ocbc_book
(
    id          int(10) unsigned NOT NULL AUTO_INCREMENT,
    title       varchar(500)     NOT NULL,
    author      varchar(10)      NOT NULL DEFAULT 'ocbc' COMMENT 'COMPANY ocbc，PERSON username',
    summary     varchar(2000)             DEFAULT NULL,
    image       varchar(200)              DEFAULT NULL COMMENT 'Path of image',
    create_time datetime(3)      NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    update_time datetime(3)      NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
    delete_time datetime(3)               DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
