use `gymnastics_federation`;

CREATE TABLE `sportsmans`
(
    `id` INT auto_increment NOT NULL,
    `person_id` INT NOT NULL,
    `regis_number` varchar(128) NOT NULL,
    `doping`    varchar(128)       NOT NULL,
    `school_id` INT NOT NULL ,
    `discipline_id` INT NOT NULL,
    `sportsman_ranking_id` INT NOT NULL ,
    `results` varchar(128) NOT NULL ,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_sportsman_person` FOREIGN KEY (`person_id`) REFERENCES `persons` (`id`),
    CONSTRAINT `fk_sportsman_school` FOREIGN KEY (`school_id`) REFERENCES `schools` (`id`),
    CONSTRAINT `fk_sportsman_discipline` FOREIGN KEY (`discipline_id`) REFERENCES `disciplines` (`id`),
    CONSTRAINT `fk_sportsman_ranking` FOREIGN KEY (`sportsman_ranking_id`) REFERENCES `sportsman_ranking` (`id`)
);