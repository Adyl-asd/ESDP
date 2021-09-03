use `esdp`;

insert into `photos` (file_path) values
     ('photo-1.jpg'),
     ('photo-2.jpg'),
     ('photo-3.jpg');

insert into `persons` (surname, name, middle_name, photo_id, birthday, iin, gender, city, address, phone, email, education, comment) values
    ('Иванова', 'Алина', 'Юрьева', 1, '1999-05-05', '990505508987', 'Женский', 'Алматы', 'ул.Сатпаева, д.5', '874787878787', 'alina@gmail.com', 'КГУ ОШ №65', 'Непереносимость лактозы') ,
    ('Алимова', 'Крина', 'Тимуровна', 2, '2001-05-05', '010505508987', 'Женский', 'Алматы', 'ул.Жандосова, д.5', '874787878787', 'karina@gmail.com', 'КГУ ОШ №88', 'Строгие родители') ,
    ('Керимбаев', 'Жандос', 'Каирович', 1, '1995-05-05', '950505508987', 'Мужской', 'Алматы', 'ул.Макатаева, д.5', '874787878787', 'zhanbo@gmail.com', 'Специализированная школа №22', 'телефон мамы: 877777777777') ,
    ('Каиров', 'Мансур', 'Еркенович', 2, '1999-05-05', '990505508958', 'Мужской', 'Алматы', 'ул.Сейфуллина, д.5', '874787878787', 'mans@gmail.com', 'Специализированная школа №22', 'увлекается футболом');

insert into `disciplines` (name) values
     ('Спортивная гимнастика мужчины'),
     ('Художественная гимнастика'),
     ('Спортивная гимнастика женщины'),
     ('Спортивная акробатика'),
     ('Аэробная гимнастика'),
     ('Батутная гимнастика');

insert into `ranks` (name) values
   ('Заслуженный мастер спорта Республики Казахстан'),
   ('Мастер спорта международного класса Республики Казахстан'),
   ('Мастер спорта Республики Казахстан'),
   ('Кандидат в мастера спорта Республики Казахстан'),
   ('1 разряд'),
   ('2 разряд'),
   ('3 разряд'),
   ('1 юношеский разряд'),
   ('2 юношеский разряд'),
   ('3 юношеский разряд');

insert into `coach_categories` (name) values
  ('Заслуженный тренер Республики Казахстан'),
  ('Тренер высшего уровня квалификации высшей категории'),
  ('Тренер-преподаватель высшего уровня квалификации высшей категории'),
  ('Тренер высшего уровня квалификации первой категории'),
  ('Тренер-преподаватель высшего уровня квалификации первой категории'),
  ('Тренер высшего уровня квалификации второй категории'),
  ('Тренер-преподаватель высшего уровня квалификации второй категории'),
  ('Тренер среднего уровня квалификации высшей категории'),
  ('Тренер-преподаватель среднего уровня квалификации высшей категории'),
  ('Тренер среднего уровня квалификации высшей категории'),
  ('Тренер-преподаватель среднего уровня квалификации высшей категории'),
  ('Тренер среднего уровня квалификации первой категории'),
  ('Тренер-преподаватель среднего уровня квалификации первой категории'),
  ('Тренер среднего уровня квалификации второй категории'),
  ('Тренер-преподаватель среднего уровня квалификации второй категории'),
  ('Без категории');

insert into `judge_categories` (name) values
    ('Судья международной категории'),
    ('Национальный спортивный судья высшей категории'),
    ('Национальный спортивный судья'),
    ('Спортивный судья первой категории');

insert into `federations` (name, director, address, email, password, phone) values
    ('Федерация гимнастики г. Алматы', 'Токарева Анна', 'г. Алматы, ул. Сатпаева', 'federation1@gym.kz', '12345678', '87077078787');


insert into `schools` (name, director, address, email, password, phone, federation_id) values
    ('Школа гимнастики №1', 'Кутушова Гульшат', 'г. Алматы, ул. Сатпаева', 'school1@gym.kz', '12345678', '87077078787', 1),
    ('Школа гимнастики №2', 'Смирнова Наталья', 'г. Алматы, ул. Абая', 'school2@gym.kz', '12345678', '87077078787', 1),
    ('Школа гимнастики №3', 'Абилова Айша', 'г. Алматы, ул. Жандосова', 'school3@gym.kz', '12345678', '87077078787', 1);


