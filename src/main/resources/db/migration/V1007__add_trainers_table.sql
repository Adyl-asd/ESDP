use `gymnastics_federation`;

CREATE TABLE `trainers`
(
    `id`      INT auto_increment NOT NULL,
    `person_id` INT NOT NULL,
    `regis_number` varchar(128) NOT NULL,
    `doping`    varchar(128)       NOT NULL,
    `school_id` INT NOT NULL ,
    `discipline_id` INT NOT NULL,
    `trainer_categories_id` INT NOT NULL ,
    PRIMARY KEY (`id`),
        CONSTRAINT `fk_trainer_category` FOREIGN KEY (`trainer_categories_id`) REFERENCES `trainer_categories` (`id`),
        CONSTRAINT `fk_trainer_person` FOREIGN KEY (`person_id`) REFERENCES `persons` (`id`),
        CONSTRAINT `fk_trainer_school` FOREIGN KEY (`school_id`) REFERENCES `schools` (`id`),
        CONSTRAINT `fk_trainer_discipline` FOREIGN KEY (`discipline_id`) REFERENCES `disciplines` (`id`)
);

