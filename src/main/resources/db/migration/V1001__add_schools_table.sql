use `gymnastics_federation`;

CREATE TABLE `schools`
(
    `id`      INT auto_increment NOT NULL,
    `name`    varchar(128)       NOT NULL,
    `address` varchar(128) NOT NULL,
    PRIMARY KEY (`id`)
);