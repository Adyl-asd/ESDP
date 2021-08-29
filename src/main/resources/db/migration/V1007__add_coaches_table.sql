use `gymnastics_federation`;

CREATE TABLE `coaches`
(
    `id`      INT auto_increment NOT NULL,
    `person_id` INT NOT NULL,
    `registry_number` varchar(128) NOT NULL,
    `dopingFile_id` int not null references `doping_files`(`id`),
    `school_id` INT NOT NULL ,
    `discipline_id` INT NOT NULL,
    `trainer_categories_id` INT NOT NULL ,
    `category_file_id` int NOT NULL references `coach_category_files` (`id`),
    PRIMARY KEY (`id`),
        CONSTRAINT `fk_trainer_category` FOREIGN KEY (`trainer_categories_id`) REFERENCES `trainer_categories` (`id`),
        CONSTRAINT `fk_trainer_person` FOREIGN KEY (`person_id`) REFERENCES `persons` (`id`),
        CONSTRAINT `fk_trainer_school` FOREIGN KEY (`school_id`) REFERENCES `schools` (`id`),
        CONSTRAINT `fk_trainer_discipline` FOREIGN KEY (`discipline_id`) REFERENCES `disciplines` (`id`)
);

