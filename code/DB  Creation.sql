DROP SCHEMA IF EXISTS traductordb;
CREATE SCHEMA traductordb ;
CREATE USER IF NOT EXISTS app@'%' IDENTIFIED BY '0000';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'app'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

USE traductordb;
INSERT INTO rol(id, name) values (1, 'Defaul Role');
INSERT INTO user(admin, nickname, password, rol_id) values (true, 'admin', '0000', 1), (false, 'user', '0000', 1);