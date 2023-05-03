create table if not exists students (id bigserial primary key, name varchar(255), score int, secret_key varchar(255));

insert into students (name, score, secret_key)
values
('Bob', 100, 'sdtu*&^dsft6UF'),
('Jack', 80, 'sdtu*&^dsft6UF'),
('John', 90, 'sdtu*&^dsft6UF'),
('John2', 90, 'sdtu*&^dsft6UF'),
('John3', 90, 'sdtu*&^dsft6UF'),
('John4', 90, 'sdtu*&^dsft6UF'),
('John5', 90, 'sdtu*&^dsft6UF'),
('John6', 90, 'sdtu*&^dsft6UF'),
('John7', 90, 'sdtu*&^dsft6UF'),
('John8', 90, 'sdtu*&^dsft6UF'),
('John9', 90, 'sdtu*&^dsft6UF'),
('John10', 90, 'sdtu*&^dsft6UF'),
('John11', 90, 'sdtu*&^dsft6UF'),
('John12', 90, 'sdtu*&^dsft6UF'),
('John13', 90, 'sdtu*&^dsft6UF'),
('John14', 90, 'sdtu*&^dsft6UF');