use `esdp`;

CREATE TABLE `judges`
(
    `id`      INT auto_increment NOT NULL,
    `person_id` INT NOT NULL,
    `registry_number` varchar(128) NOT NULL,
    `discipline_id` INT NOT NULL,
    `judge_categories_id` INT NOT NULL ,
    `category_file_id` int NOT NULL references `judge_category_files` (`id`),
    `is_del` boolean default false,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_judge_category` FOREIGN KEY (`judge_categories_id`) REFERENCES `judge_categories` (`id`),
    CONSTRAINT `fk_judge_person` FOREIGN KEY (`person_id`) REFERENCES `persons` (`id`),
    CONSTRAINT `fk_judge_discipline` FOREIGN KEY (`discipline_id`) REFERENCES `disciplines` (`id`)
);