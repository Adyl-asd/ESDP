use `esdp`;

CREATE TABLE `competitions_discipline_ages`(
    `id`      INT auto_increment NOT NULL,
    `team_championship` INT NOT NULL,
    `competition_id` int not null references `competitions` (`id`),
    `age_category_id` int not null references `age_categories` (`id`),
    `discipline_id` int not null references `discipline_types` (`id`),
    PRIMARY KEY (`id`)
);

CREATE TABLE `competitions_discipline_programs`(
    `id`      INT auto_increment NOT NULL,
    `competition_id` int not null references `competitions` (`id`),
    `competition_program_id` int not null references `competition_programs` (`id`),
    `discipline_id` int not null references `discipline_types` (`id`),
    PRIMARY KEY (`id`)
);
