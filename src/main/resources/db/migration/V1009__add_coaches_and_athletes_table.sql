use `gymnastics_federation`;

CREATE TABLE `athletes_coaches`
(
    `id`      INT auto_increment NOT NULL,
    `coach_id` INT NOT NULL,
    `athlete_id` INT NOT NULL ,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_trainers` FOREIGN KEY (`coach_id`) REFERENCES `coaches` (`id`),
    CONSTRAINT `fk_sportsmans` FOREIGN KEY (`athlete_id`) REFERENCES `athletes` (`id`)
);