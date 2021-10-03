use `esdp`;

CREATE TABLE `participation_applications`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `creation_date` DATE NOT NULL,
    `is_del` BOOLEAN NOT NULL,
    `status` varchar(120) NOT NULL,
    `school_id` INT NOT NULL REFERENCES `schools`(`id`),
    `competition_id` INT NOT NULL REFERENCES `competitions`(`id`),
    PRIMARY KEY (`id`)
);

CREATE TABLE `participation_applications_athletes`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `application_id` INT NOT NULL REFERENCES `participation_applications`(`id`),
    `athlete_id` INT NOT NULL REFERENCES  `athletes`(`id`),
    `discipline_age_id` INT NOT NULL REFERENCES `competitions_discipline_ages`(`id`),
    `discipline_type_id` INT NOT NULL REFERENCES `discipline_types`(`id`),
    `team_number` INT NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `participation_applications_judges`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `application_id` INT NOT NULL REFERENCES `participation_applications`(`id`),
    `judge_id` INT NOT NULL REFERENCES  `judges`(`id`),
    PRIMARY KEY (`id`)
);

CREATE TABLE `participation_applications_coaches`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `application_id` INT NOT NULL REFERENCES `participation_applications`(`id`),
    `coach_id` INT NOT NULL REFERENCES  `coaches`(`id`),
    PRIMARY KEY (`id`)
);