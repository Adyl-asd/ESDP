use `esdp`;

insert into `disciplines` (name)
values ('Спортивная гимнастика'),
       ('Художественная гимнастика');

insert into `disciplines` (name, is_team_champ_by_discipline_type)
values ('Спортивная акробатика', false);

insert into `disciplines` (name)
values
    ('Аэробная гимнастика'),
    ('Батутная гимнастика');

CREATE TABLE `discipline_types`
(
    `id`                      INT auto_increment NOT NULL,
    `name`                    varchar(128)       NOT NULL,
    `participants_amount_min` integer,
    `participants_amount_max` integer,
    `gender_id`               int references `genders` (`id`),
    `is_del`                  boolean default false,
    `discipline_id`           int references `disciplines` (`id`),
    PRIMARY KEY (`id`)
);

CREATE TABLE `genders`
(
    `id`     INT auto_increment NOT NULL,
    `name`   varchar(128)       NOT NULL,
    `is_del` boolean            not null default false,
    PRIMARY KEY (`id`)
);

INSERT INTO `genders`(name)
VALUES ('Мужской'),
       ('Женский'),
       ('Смешанный');

#спортивная гимнастика
insert into `discipline_types` (name, discipline_id)
values ('Спортивная гимнастика женщины', 1),
       ('Спортивная гимнастика мужчины', 1);

#худ гимнастика
insert into `discipline_types` (name, discipline_id)
values ('Индивидуальная программа', 2);

#худ гимнастика
insert into `discipline_types` (name, discipline_id, participants_amount_min, participants_amount_max)
values ('Групповые упражнения', 2, 5, 6);

#батут гимнастика
insert into `discipline_types` (name, discipline_id)
values ('Индивидуальные прыжки на батуте', 5),
       ('Прыжки на акробатической дорожке', 5),
       ('Прыжки на двойном минитрампе', 5);

#батут гимнастика
insert into `discipline_types` (name, discipline_id, participants_amount_min, participants_amount_max)
values ('Синхронные прыжки на батуте', 5, 2, 2);

#спорт акробатика
insert into `discipline_types` (name, discipline_id, participants_amount_min, participants_amount_max, gender_id)
values ('Мужская пара', 3, 2, 2, 1),
       ('Женская пара', 3, 2, 2, 2),
       ('Смешанная пара', 3, 2, 2, 3),
       ('Женская группа', 3, 3, 3, 2),
       ('Мужская группа', 3, 4, 4, 1);

#аэробная гимнастика
insert into `discipline_types` (name, discipline_id, gender_id)
values ('Индивидуальные выступления женщин', 4, 2),
       ('Индивидуальные выступления мужчин', 4, 1);

#аэробная гимнастика
insert into `discipline_types` (name, discipline_id, participants_amount_min, participants_amount_max, gender_id)
values ('Смешанная пара', 4, 2, 2, 3),
       ('Трио', 4, 3, 3, 3),
       ('Группы', 4, 5, 5, 3),
       ('Танцевальная гимнастика', 4, 6, 8, 3),
       ('Гимнастическая платформа', 4, 6, 8, 3);

CREATE TABLE `age_categories`
(
    `id`                 INT auto_increment NOT NULL,
    `min_year`           integer,
    `max_year`           integer,
    `is_del`             boolean default false,
    `rank_id`            int references `ranks` (`id`),
    `discipline_id` int references `discipline_types` (`id`),
    PRIMARY KEY (`id`)
);

#спорт гимнастика жен
insert into `age_categories` (min_year, rank_id, discipline_id)
values (2008, 3, 1),
       (2010, 4, 1);

#спорт гимнастика жен
insert into `age_categories` (min_year, max_year, rank_id, discipline_id)
values (2009, 2011, 5, 1),
       (2010, 2013, 6, 1),
       (2012, 2014, 7, 1);

#спорт гимнастика муж
insert into `age_categories` (min_year, rank_id, discipline_id)
values (2005, 3, 2);

#спорт гимнастика муж
insert into `age_categories` (min_year, max_year, rank_id, discipline_id)
values (2004, 2007, 4, 2),
       (2006, 2009, 5, 2),
       (2008, 2011, 6, 2),
       (2010, 2012, 7, 2);

#худ инд и групп
insert into `age_categories` (min_year, max_year, discipline_id)
values (2006, 2013, 3),
       (2006, 2013, 4);

#худ инд и групп
insert into `age_categories` (min_year, rank_id, discipline_id)
values (2005, 3, 3),
       (2005, 3, 4);

#худ инд и групп
insert into `age_categories` (min_year, max_year, rank_id, discipline_id)
values (2006, 2008, 4, 3),
       (2006, 2008, 4, 4);

#худ инд и групп
insert into `age_categories` (max_year, rank_id, discipline_id)
values (2009, 5, 3),
       (2009, 5, 4);

#батут гимн
insert into `age_categories` (max_year, discipline_id)
values (2009, 5),
       (2009, 6),
       (2009, 7),
       (2009, 8);

#батут гимн
insert into `age_categories` (min_year, max_year, discipline_id)
values (2007, 2008, 5),
       (2007, 2008, 6),
       (2007, 2008, 7),
       (2007, 2008, 8),
       (2005, 2006, 5),
       (2005, 2006, 6),
       (2005, 2006, 7),
       (2005, 2006, 8),
       (2000, 2004, 5),
       (2000, 2004, 6),
       (2000, 2004, 7),
       (2000, 2004, 8);

#батут гимн
insert into `age_categories` (min_year, discipline_id)
values (2009, 5),
       (2009, 6),
       (2009, 7),
       (2009, 8);

#спорт акроб
insert into `age_categories` (max_year, discipline_id)
values (2006, 9),
       (2006, 10),
       (2006, 11),
       (2006, 12),
       (2006, 13),
       (2004, 9),
       (2004, 10),
       (2004, 11),
       (2004, 12),
       (2004, 13);

#спорт акроб
insert into `age_categories` (min_year, discipline_id)
values (2009, 9),
       (2009, 10),
       (2009, 11),
       (2009, 12),
       (2009, 13);

#спорт акроб
insert into `age_categories` (min_year, max_year, discipline_id)
values (2003, 2009, 9),
       (2003, 2009, 10),
       (2003, 2009, 11),
       (2003, 2009, 12),
       (2003, 2009, 13),
       (2002, 2008, 9),
       (2002, 2008, 10),
       (2002, 2008, 11),
       (2002, 2008, 12),
       (2002, 2008, 13);

#аэроб гимн
insert into `age_categories` (min_year, discipline_id)
values (2002, 14),
       (2002, 15),
       (2002, 16),
       (2002, 17),
       (2002, 18),
       (2002, 19),
       (2002, 20);

#аэроб гимн
insert into `age_categories` (min_year, max_year, discipline_id)
values (2003, 2005, 14),
       (2003, 2005, 15),
       (2003, 2005, 16),
       (2003, 2005, 17),
       (2003, 2005, 18),
       (2003, 2005, 19),
       (2003, 2005, 20),
       (2006, 2008, 14),
       (2006, 2008, 15),
       (2006, 2008, 16),
       (2006, 2008, 17),
       (2006, 2008, 18),
       (2006, 2008, 19),
       (2006, 2008, 20);

CREATE TABLE `competition_programs`
(
    `id`                 INT auto_increment NOT NULL,
    `name`               varchar(128)       NOT NULL,
    `is_del`             boolean default false,
    `age_category_id`    int references `age_categories` (`id`),
    `discipline_id` integer references `discipline_types` (`id`),
    `type`               varchar(127),
    PRIMARY KEY (`id`)
);

#спорт гимн женщ
insert into `competition_programs` (name, discipline_id)
values
       ('Вольные упражнения', 1),
       ('Брусья', 1),
       ('Бревно', 1),
       ('Опорный прыжок', 1);


#спорт гимн муж
insert into `competition_programs` (name, discipline_id)
values
       ('Вольные упражнения', 2),
       ('Брусья', 2),
       ('Кольца', 2),
       ('Конь', 2),
       ('Перекладина', 2),
       ('Опорный прыжок', 2);

#худ гимн инд
insert into `competition_programs` (name, discipline_id)
values
       ('Без предмета', 3),
       ('Скакалка', 3),
       ('Обруч', 3),
       ('Мяч', 3),
       ('Булавы', 3),
       ('Лента', 3);

#худ гимн групп
insert into `competition_programs` (name, discipline_id)
values
       ('5 предметов', 4),
       ('2+3 предмета', 4);

#бабут гимн
insert into `competition_programs` (name, discipline_id)
values
       ('1 упражнение', 5),
       ('1 упражнение', 6),
       ('1 упражнение', 7),
       ('1 упражнение', 8),
       ('2 упражнение', 5),
       ('2 упражнение', 6),
       ('2 упражнение', 7),
       ('2 упражнение', 8);

#спорт акр
insert into `competition_programs` (name, discipline_id)
values
       ('1 упражнение', 9),
       ('1 упражнение', 10),
       ('1 упражнение', 11),
       ('1 упражнение', 12),
       ('1 упражнение', 13),
       ('2 упражнение', 9),
       ('2 упражнение', 10),
       ('2 упражнение', 11),
       ('2 упражнение', 12),
       ('2 упражнение', 13),
       ('3 упражнение', 9),
       ('3 упражнение', 10),
       ('3 упражнение', 11),
       ('3 упражнение', 12),
       ('3 упражнение', 13);

#аэроб гимн
insert into `competition_programs` (name, discipline_id)
values
       ('Индивидуальные выступление', 14),
       ('Индивидуальные выступление', 15),
       ('Индивидуальные выступление', 16),
       ('Индивидуальные выступление', 17),
       ('Индивидуальные выступление', 18),
       ('Индивидуальные выступление', 19),
       ('Индивидуальные выступление', 20);



