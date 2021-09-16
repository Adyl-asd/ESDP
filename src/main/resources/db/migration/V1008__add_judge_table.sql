use `esdp`;

CREATE TABLE `judges`(
    `id` INT auto_increment NOT NULL,
    `person_id` INT NOT NULL,
    `registry_number` varchar(128) NOT NULL,
    `school_id` INT NOT NULL,
    `doping_file_id` INT NOT NULL,
    `discipline_id` INT NOT NULL,
    `category_id` INT NOT NULL,
    `category_file_id` int NOT NULL,
    `is_del` boolean default false,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_judge_category` FOREIGN KEY (`category_id`) REFERENCES `judge_categories` (`id`),
    CONSTRAINT `fk_judge_school` FOREIGN KEY (`school_id`) REFERENCES `schools` (`id`),
    CONSTRAINT `fk_judge_doping_file` FOREIGN KEY (`doping_file_id`) REFERENCES `doping_files` (`id`),
    CONSTRAINT `fk_judge_category_file` FOREIGN KEY (`category_file_id`) REFERENCES `judge_category_files` (`id`),
    CONSTRAINT `fk_judge_person` FOREIGN KEY (`person_id`) REFERENCES `persons` (`id`),
    CONSTRAINT `fk_judge_discipline` FOREIGN KEY (`discipline_id`) REFERENCES `disciplines` (`id`)
);