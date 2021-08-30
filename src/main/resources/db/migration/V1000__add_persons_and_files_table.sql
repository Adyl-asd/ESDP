use `gymnastics_federation`;

create table `photos`(
     `id` int auto_increment not null,
     `file_path` varchar(128) not null,
     primary key (`id`)
);

create table `registry_files`(
     `id` int auto_increment not null,
     `file_path` varchar(128) not null,
     primary key (`id`)
);

create table `medical_files`(
    `id` int auto_increment not null,
    `file_path` varchar(128) not null,
    primary key (`id`)
);

create table `rank_files`(
     `id` int auto_increment not null,
     `file_path` varchar(128) not null,
     primary key (`id`)
);

create table `doping_files`(
       `id` int auto_increment not null,
       `file_path` varchar(128) not null,
       primary key (`id`)
);

create table `coach_category_files`(
   `id` int auto_increment not null,
   `file_path` varchar(128) not null,
   primary key (`id`)
);

create table `judge_category_files`(
   `id` int auto_increment not null,
   `file_path` varchar(128) not null,
   primary key (`id`)
);

CREATE TABLE `persons`
(
    `id`      INT auto_increment NOT NULL,
    `surname`    varchar(128)       NOT NULL,
    `name`    varchar(128)       NOT NULL,
    `middle_name`    varchar(128)       NOT NULL,
    `photo_id` int NOT NULL references `photos`(`id`),
    `iin` INT NOT NULL,
    `gender` varchar(128) NOT NULL,
    `birthday` date NOT NULL,
    `city` varchar(128) NOT NULL,
    `address` varchar(128) NOT NULL,
    `education` varchar(128) NOT NULL,
    `phone` varchar(128) NOT NULL,
    `email` varchar(128) NOT NULL,
    `comment` varchar(400) not null,
    PRIMARY KEY (`id`)
);