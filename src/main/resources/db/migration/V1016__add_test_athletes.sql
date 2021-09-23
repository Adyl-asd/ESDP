use esdp;

INSERT INTO `medical_files` (file_path) VALUES
('P6.01 - ru - 10100533598058.pdf');

INSERT INTO `doping_files` (file_path) VALUES
    ('P6.01 - ru - 10100533598058.pdf');

INSERT INTO `registry_files` (file_path) VALUES
    ('P6.01 - ru - 10100533598058.pdf');

INSERT INTO `rank_files` (file_path) VALUES
    ('P6.01 - ru - 10100533598058.pdf');

INSERT INTO `coach_category_files` (file_path) VALUES
    ('P6.01 - ru - 10100533598058.pdf');

INSERT INTO `judge_category_files` (file_path) VALUES
    ('P6.01 - ru - 10100533598058.pdf');


INSERT INTO `athletes`(person_id, school_id, registry_number, registry_file_id, medical_file_id, doping_file_id, status, registry_date, is_city_team, is_national_team, discipline_id, rank_id, rank_file_id) VALUES
(1, 1, 1, 1, 1, 1, 'АКТИВНЫЙ', '2020-01-01', true, true, 1, 1, 1),
(2, 1, 1, 1, 1, 1, 'АКТИВНЫЙ', '2020-01-01', true, true, 1, 1, 1),
(3, 1, 1, 1, 1, 1, 'АКТИВНЫЙ', '2020-01-01', true, true, 1, 1, 1),
(3, 2, 1, 1, 1, 1, 'АКТИВНЫЙ', '2020-01-01', true, true, 1, 1, 1),
(2, 2, 1, 1, 1, 1, 'АКТИВНЫЙ', '2020-01-01', true, true, 1, 1, 1),
(1, 2, 1, 1, 1, 1, 'АКТИВНЫЙ', '2020-01-01', true, true, 1, 1, 1),
(1, 1, 1, 1, 1, 1, 'АКТИВНЫЙ', '2020-01-01', true, true, 2, 1, 1),
(2, 1, 1, 1, 1, 1, 'АКТИВНЫЙ', '2020-01-01', true, true, 2, 1, 1),
(3, 1, 1, 1, 1, 1, 'АКТИВНЫЙ', '2020-01-01', true, true, 2, 1, 1),
(3, 2, 1, 1, 1, 1, 'АКТИВНЫЙ', '2020-01-01', true, true, 2, 1, 1),
(2, 2, 1, 1, 1, 1, 'АКТИВНЫЙ', '2020-01-01', true, true, 2, 1, 1),
(1, 2, 1, 1, 1, 1, 'АКТИВНЫЙ', '2020-01-01', true, true, 2, 1, 1);

INSERT INTO `coaches`(person_id, registry_number, school_id, discipline_id, category_id, category_file_id, is_del) VALUES
(1, 1, 1, 1, 1, 1, false),
(2, 1, 1, 1, 1, 1, false),
(3, 1, 1, 1, 1, 1, false),
(1, 1, 2, 1, 1, 1, false),
(2, 1, 2, 1, 1, 1, false),
(3, 1, 2, 1, 1, 1, false),
(1, 1, 1, 2, 1, 1, false),
(2, 1, 1, 3, 1, 1, false),
(3, 1, 1, 4, 1, 1, false),
(1, 1, 2, 2, 1, 1, false),
(2, 1, 2, 3, 1, 1, false),
(3, 1, 2, 4, 1, 1, false);

INSERT INTO `judges` (person_id, registry_number, school_id, doping_file_id, discipline_id, category_id, category_file_id) VALUES
(1, 1, 1, 1, 1, 1, 1),
(2, 1, 1, 1, 1, 1, 1),
(3, 1, 1, 1, 2, 1, 1),
(1, 1, 2, 1, 4, 1, 1),
(2, 1, 3, 1, 3, 1, 1),
(3, 1, 2, 1, 2, 1, 1);