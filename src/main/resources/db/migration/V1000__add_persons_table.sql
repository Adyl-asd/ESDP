use `gymnastics_federation`;

CREATE TABLE `persons`
(
    `id`      INT auto_increment NOT NULL,
    `surname`    varchar(128)       NOT NULL,
    `name`    varchar(128)       NOT NULL,
    `middle_name`    varchar(128)       NOT NULL,
    `photo` varchar(128) NOT NULL,
    `individual_identification_number` INT NOT NULL,
    `gender` varchar(128) NOT NULL,
    `birthday_date` date NOT NULL,
    `city` varchar(128) NOT NULL,
    `address` varchar(128) NOT NULL,
    `education` varchar(128) NOT NULL,
    `phone` varchar(128) NOT NULL,
    `email` varchar(128) NOT NULL,
    PRIMARY KEY (`id`)
);