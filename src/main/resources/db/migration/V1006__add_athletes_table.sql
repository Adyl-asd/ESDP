use `esdp`;

CREATE TABLE `athletes`(
    `id` int auto_increment not null,
    `person_id` int not null references `persons` (`id`),
    `school_id` int not null references `schools` (`id`),
    `registry_number` int not null,
    `registry_file_id` int not null references `registry_files`(`id`),
    `medical_file_id` int not null references `medical_files`(`id`),
    `doping_file_id` int not null references `doping_files`(`id`),
    `status` varchar(128) not null,
    `registry_date` date not null,
    `discipline_id` int not null references `disciplines` (`id`),
    `rank_id` int not null references `ranks`(`id`),
    `rank_file_id` int not null references `rank_files`(`id`),
    `is_del` boolean default false,
    primary key (`id`)
);