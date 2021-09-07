use `esdp`;


create table `competition_position_files`(
    `id` int auto_increment not null,
    `file_path` varchar(128) not null,
    primary key (`id`)
);

CREATE TABLE `competitions`
(
    `id`      INT auto_increment NOT NULL,
    `name`    varchar(128)       NOT NULL,
    `creation_date` date not null,
    `start_date` date not null,
    `finish_date` date not null,
    `country`    varchar(128)       NOT NULL,
    `city`    varchar(128)       NOT NULL,
    `address`    varchar(128)       NOT NULL,
    `area_name`    varchar(128)       NOT NULL,
    `contact`    varchar(128)       NOT NULL,
    `phone`    varchar(128)       NOT NULL,
    `discipline_id` int not null references `disciplines`(`id`),
    `status`    varchar(128)       NOT NULL,
    `competition_position_file_id` int not null references `competition_position_files` (`id`),
    `is_del` boolean default false,
    `school_id` int not null references `schools`(`id`),
    PRIMARY KEY (`id`)
);
