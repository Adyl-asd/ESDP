use `esdp`;

CREATE TABLE `participation_applications`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `creation_date` DATE NOT NULL,
    `is_del` BOOLEAN NOT NULL,
    `school_id` INT NOT NULL REFERENCES `schools`(`id`),
    `competition_id` INT NOT NULL REFERENCES `competitions`(`id`)
);