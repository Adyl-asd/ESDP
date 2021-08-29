use `gymnastics_federation`;

create table `federations`(
      `id` int auto_increment not null,
      `name` varchar(128) not null,
      `director` varchar(128) not null ,
      `email` varchar(128) not null,
      `password` varchar(128) not null,
      `address` varchar(128) not null,
      `phone` varchar(128) not null,
      primary key (`id`)
);

create table `schools`(
      `id` int auto_increment not null,
      `name` varchar(128) not null,
      `director` varchar(128) not null ,
      `email` varchar(128) not null,
      `password` varchar(128) not null,
      `address` varchar(128) not null,
      `phone` varchar(128) not null,
      `federation_id` int not null references `federations` (`id`),
      primary key (`id`)
);