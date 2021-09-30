use `esdp`;

CREATE TABLE `athletes_coaches`(
    `id`      INT auto_increment NOT NULL,
    `coach_id` INT NOT NULL,
    `athlete_id` INT NOT NULL ,
    `school_id` INT NOT NULL REFERENCES `schools` (`id`),
    `register_date` DATE NOT NULL,
    `finish_date` DATE,
    `is_del` boolean NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_trainers` FOREIGN KEY (`coach_id`) REFERENCES `coaches` (`id`),
    CONSTRAINT `fk_sportsmans` FOREIGN KEY (`athlete_id`) REFERENCES `athletes` (`id`)
);