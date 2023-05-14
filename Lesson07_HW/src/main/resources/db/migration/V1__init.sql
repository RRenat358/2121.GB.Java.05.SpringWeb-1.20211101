create table if not exists products (id bigserial primary key, name varchar(255), price int);

insert into products (name, price)
values
('Яблоки', 40),
('Бананы', 60),
('Груши', 50),
('Морковь', 15),
('Свекла', 23),
('Картофель', 18);