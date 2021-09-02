use `esdp`;

CREATE TABLE `disciplines`
(
    `id`      INT auto_increment NOT NULL,
    `name`    varchar(128)       NOT NULL,
    `is_del` boolean default false,
    PRIMARY KEY (`id`)
);