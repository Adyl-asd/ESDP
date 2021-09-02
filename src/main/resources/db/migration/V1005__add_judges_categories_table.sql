use `esdp`;

CREATE TABLE `judge_categories`
(
    `id`      INT auto_increment NOT NULL,
    `number`    integer     NOT NULL,
    `is_del` boolean default false,
    PRIMARY KEY (`id`)
);