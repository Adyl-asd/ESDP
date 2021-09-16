use `esdp`;

CREATE TABLE `disciplines` (
    `id`      INT auto_increment NOT NULL,
    `is_team_champ_by_discipline_type` boolean not null default true,
    `name`    varchar(128)       NOT NULL,
    `is_del` boolean default false,
    PRIMARY KEY (`id`)
);