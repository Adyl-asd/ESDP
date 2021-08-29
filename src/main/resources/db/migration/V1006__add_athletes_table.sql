use `gymnastics_federation`;

CREATE TABLE `athletes`
(
    `id` int auto_increment not null,
    `person_id` int not null references `persons` (`id`),
    `school_id` int not null references `schools` (`id`),
    `registryNumber` int not null,
    `registryFile_id` int not null references `registry_files`(`id`),
    `medicalFile_id` int not null references `medical_files`(`id`),
    `dopingFile_id` int not null references `doping_files`(`id`),
    `status` varchar(128) not null default 'active',
    `registryDate` date not null,
    `discipline_id` int not null references `disciplines` (`id`),
    `rank_id` int not null references `ranks`(`id`),
    `rankFile_id` int not null references `rank_files`(`id`),
    primary key (`id`)
);