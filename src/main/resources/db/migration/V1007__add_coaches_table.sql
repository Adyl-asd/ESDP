use `esdp`;

CREATE TABLE `coaches`(
    `id`      INT auto_increment NOT NULL,
    `person_id` INT NOT NULL,
    `registry_number` varchar(128) NOT NULL,
    `school_id` INT NOT NULL ,
    `discipline_id` INT NOT NULL,
    `category_id` INT NOT NULL,
    `category_file_id` int NOT NULL references `coach_category_files` (`id`),
    `is_del` boolean default false,
    PRIMARY KEY (`id`),
        CONSTRAINT `fk_coach_category` FOREIGN KEY (`category_id`) REFERENCES `coach_categories` (`id`),
        CONSTRAINT `fk_coach_person` FOREIGN KEY (`person_id`) REFERENCES `persons` (`id`),
        CONSTRAINT `fk_coach_school` FOREIGN KEY (`school_id`) REFERENCES `schools` (`id`),
        CONSTRAINT `fk_coach_discipline` FOREIGN KEY (`discipline_id`) REFERENCES `disciplines` (`id`)
);

