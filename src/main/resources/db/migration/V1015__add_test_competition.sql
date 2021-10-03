use esdp;

INSERT INTO `competition_position_files`(file_path) VALUES
('P7.04 - ru - 10100526300338.pdf');

INSERT INTO `competitions` (name, creation_date, start_date, finish_date, participation_date, level, country, city, address, area_name, contact, phone, discipline_id, status, competition_position_file_id, is_del, school_id) VALUES
('Соревнование тест', '2021-09-22', '2021-10-01', '2021-10-10', '2021-09-27', 'Региональный', 'РК', 'Алматы', 'Абая, 150', 'Спорт комплекс 1', 'Иванова Марина', '87077077777', 2, 'СОЗДАНО', 1, false, 1);


INSERT INTO `competitions_discipline_ages` (team_championship, competition_id, age_category_id, discipline_id) VALUES
    (1, 1, 11, 3),
    (1, 1, 12, 3),
    (1, 1, 13, 3),
    (1, 1, 14, 3),
    (2, 1, 12, 4),
    (2, 1, 13, 4),
    (2, 1, 14, 4),
    (2, 1, 15, 4);

INSERT INTO `competitions_discipline_programs` (competition_id, competition_program_id, discipline_id) VALUES
    (1, 11, 3),
    (1, 12, 3),
    (1, 13, 3),
    (1, 14, 3),
    (1, 15, 3),
    (1, 16, 3),
    (1, 17, 4),
    (1, 18, 4);

