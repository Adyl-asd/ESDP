use `gymnastics_federation`;

CREATE TABLE `trainers_and_sportsmans`
(
    `id`      INT auto_increment NOT NULL,
    `trainer_id` INT NOT NULL,
    `sportsman_id` INT NOT NULL ,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_trainers` FOREIGN KEY (`trainer_id`) REFERENCES `trainers` (`id`),
    CONSTRAINT `fk_sportsmans` FOREIGN KEY (`sportsman_id`) REFERENCES `sportsmans` (`id`)
);