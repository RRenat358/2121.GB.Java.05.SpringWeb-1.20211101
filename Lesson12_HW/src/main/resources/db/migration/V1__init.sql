
-- //============================================================

/*
create table if not exists products (
    id          bigserial primary key,
    title       varchar(255),
    price       int
);


insert into products (title, price)
values ('Milk', 100),
       ('Bread', 80),
       ('Cheese', 90);
*/

-- //============================================================
create table if not exists products (id bigserial primary key,
                                     name varchar(255),
    proteins varchar(255), fats varchar(255), carbohydrates varchar(255), calories varchar(255),
    group_product varchar(255),
    price int);

insert into products (
    name,
    proteins, fats, carbohydrates, calories,
    group_product,
    price)
values
    ('Абрикосы','0,7','0','10,1','44','фрукты, ягоды','190'),
    ('Айва','0,6','0','8,7','37','фрукты, ягоды','40'),
    ('Алыча','0,3','0','7,6','35','фрукты, ягоды','70'),
    ('Ананас','0,3','0','11,9','49','фрукты, ягоды','200'),
    ('Апельсин','0,8','0','8,6','38','фрукты, ягоды','50'),
    ('Бананы','1,7','0','22,1','87','фрукты, ягоды','30'),
    ('Брусника','0,6','0','8,8','42','фрукты, ягоды','90'),
    ('Виноград','0,5','0','17,8','73','фрукты, ягоды','50'),
    ('Вишня','0,9','0','11,1','46','фрукты, ягоды','100'),
    ('Гранат','0,9','0','11,9','53','фрукты, ягоды','40'),
    ('Грейпфрут','0,8','0','7,5','37','фрукты, ягоды','120'),
    ('Груша','0,5','0','10,6','41','фрукты, ягоды','130'),
    ('Голубика','1,1','0','7,4','35','фрукты, ягоды','70'),
    ('Дыня','0,8','0,3','7,3','34','фрукты, ягоды','190'),
    ('Ежевика','1,9','0','5,1','31','фрукты, ягоды','120'),
    ('Земляника','1,9','0','7,1','40','фрукты, ягоды','90'),
    ('Инжир','0,9','0','13,7','57','фрукты, ягоды','50'),
    ('Киви','1','0,7','9,7','46','фрукты, ягоды','110'),
    ('Кизил','1,1','0','9,4','42','фрукты, ягоды','50'),
    ('Клубника','0,6','0,4','7','30','фрукты, ягоды','180'),
    ('Клюква','0,7','0','4,9','27','фрукты, ягоды','90'),
    ('Крыжовник','0,8','0','9,7','43','фрукты, ягоды','90'),
    ('Лимон','0,9','0','3,3','30','фрукты, ягоды','120'),
    ('Малина','0,7','0','9,2','43','фрукты, ягоды','30'),
    ('Мандарин','0,9','0','8,8','39','фрукты, ягоды','20'),
    ('Манго','0,6','0,4','11,8','69','фрукты, ягоды','40'),
    ('Морошка','0,9','0','6,9','33','фрукты, ягоды','120'),
    ('Облепиха','0,8','0','5,6','31','фрукты, ягоды','100'),
    ('Персики','0,9','0','10,1','42','фрукты, ягоды','150'),
    ('Памело','0,6','0,1','6,1','29','фрукты, ягоды','30'),
    ('Рябина','1,6','0','12,2','57','фрукты, ягоды','200'),
    ('Слива','0,8','0','9,7','41','фрукты, ягоды','40'),
    ('Смородина белая','0,4','0','8,5','37','фрукты, ягоды','80'),
    ('Смородина красная','0,6','0','8,7','39','фрукты, ягоды','50'),
    ('Смородина черная','1','0','8','38','фрукты, ягоды','140'),
    ('Хурма','0,7','0','15,7','61','фрукты, ягоды','170'),
    ('Черешня','1,3','0','12,5','54','фрукты, ягоды','160'),
    ('Черника','1,2','0','8,8','41','фрукты, ягоды','90'),
    ('Шелковица','0,6','0','12,5','50','фрукты, ягоды','50'),
    ('Шиповник свежий','1,5','0','24,2','106','фрукты, ягоды','50'),
    ('Шиповник сушеный','4,5','0','60,1','259','фрукты, ягоды','10'),
    ('Яблоки','0,5','0','11,4','48','фрукты, ягоды','30'),
    ('Баклажаны','0,6','0,1','7,5','22','овощи','180'),
    ('Бобы','6,1','0,1','8,1','59','овощи','180'),
    ('Брюква','1,2','0,1','8,4','38','овощи','90'),
    ('Горошек зеленый','5,4','0,2','13,6','75','овощи','70'),
    ('Кабачки','0,8','0,3','5,9','30','овощи','50'),
    ('Капуста белокочанная','1,9','0','5,7','31','овощи','80'),
    ('Капуста краснокочанная','1,9','0','6,3','34','овощи','160'),
    ('Капуста цветная','2,7','0','5,2','30','овощи','110'),
    ('Картофель вареный','2','0,3','16,5','80','овощи','160'),
    ('Картофель жареный','2,6','9,7','23,5','198','овощи','70'),
    ('Картофель молодой','2,2','0,3','12,5','57','овощи','120'),
    ('Лук зеленый (перо)','1,4','0','4,2','21','овощи','70'),
    ('Лук порей','3,2','0','7,1','38','овощи','40'),
    ('Лук репчатый','1,6','0','9,3','41','овощи','10'),
    ('Морковь','1,3','0,1','6,3','29','овощи','60'),
    ('Огурцы грунтовые','0,7','0','3,1','15','овощи','100'),
    ('Огурцы парниковые','0,7','0','1,6','9','овощи','130'),
    ('Оливки','0,6','10,2','6,7','111','овощи','30'),
    ('Перец зеленый сладкий','1,2','0','4,8','24','овощи','120'),
    ('Перец красный сладкий','1,2','0','5,5','26','овощи','10'),
    ('Петрушка (зелень)','3,8','0','8','45','овощи','100'),
    ('Петрушка (корень)','1,6','0','11,2','48','овощи','150'),
    ('Редис','1,5','0','4,2','22','овощи','20'),
    ('Редька','1,7','0','7,1','33','овощи','120'),
    ('Репа','1,6','0','5,8','27','овощи','80'),
    ('Салат','1,6','0','2,1','15','овощи','10'),
    ('Свекла','1,7','0','10,5','46','овощи','140'),
    ('Томаты (грунтовые)','0,7','0','4,1','19','овощи','170'),
    ('Томаты (парниковые)','0,7','0','2,6','12','овощи','110'),
    ('Фасоль','4,4','0','4,4','36','овощи','100'),
    ('Хрен','2,6','0','16,1','70','овощи','10'),
    ('Чеснок','6,6','0','21,1','103','овощи','170'),
    ('Шпинат','2,5','0','2,6','22','овощи','70'),
    ('Щавель','1,6','0','5,5','29','овощи','10'),
    ('Арахис','26,2','45,3','9,9','555','орехи, сухофрукты','180'),
    ('Грецкий орех','13,5','61,5','10,6','662','орехи, сухофрукты','30'),
    ('Изюм с косточкой','1,7','0','70,7','273','орехи, сухофрукты','60'),
    ('Изюм кишмиш','2,5','0','71,4','285','орехи, сухофрукты','150'),
    ('Кешью','25,8','54,3','13,3','647','орехи, сухофрукты','70'),
    ('Курага','5,7','0','65,3','270','орехи, сухофрукты','80'),
    ('Миндаль','18,3','57,9','13,4','643','орехи, сухофрукты','120'),
    ('Семя подсолнечника','20,9','52,5','5,4','582','орехи, сухофрукты','30'),
    ('Урюк','5,3','0','67,9','279','орехи, сухофрукты','190'),
    ('Финики','2,5','0,4','69,6','277','орехи, сухофрукты','70'),
    ('Фисташки','20','50,5','7,3','555','орехи, сухофрукты','110'),
    ('Фундук','16,3','66,7','9,8','701','орехи, сухофрукты','200'),
    ('Чернослив','2,7','0','65,3','262','орехи, сухофрукты','140'),
    ('Яблоки сушенные','3,1','0','68,3','275','орехи, сухофрукты','190');



-- //============================================================

create table users (
    id         bigserial primary key,
    username   varchar(36) not null,
    password   varchar(80) not null,
    email      varchar(50) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table roles (
    id         bigserial primary key,
    name       varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

CREATE TABLE users_roles (
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');



-- //============================================================

insert into users (username, password, email)
values ('bob', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'bob_johnson@gmail.com'),
       ('john', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'john_johnson@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);



-- //============================================================


