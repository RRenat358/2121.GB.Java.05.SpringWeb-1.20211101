DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS product (id bigserial, price double, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO product (name, price) VALUES ('Яблоки', 40.00), ('Бананы', 60.00), ('Груши', 50.00);
