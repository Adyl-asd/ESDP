use `esdp`;

CREATE TABLE `competitions_disciplines`(
    `id`      INT auto_increment NOT NULL,
    `team_championship` INT NOT NULL,
    `competition_id` int not null references `competitions` (`id`),
    `age_category_id` int not null references `age_categories` (`id`),
    `competition_program_id` int not null references `competition_programs` (`id`),
    `discipline_type_id` int not null references `discipline_types` (`id`),
    PRIMARY KEY (`id`)
);
