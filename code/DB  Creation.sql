DROP SCHEMA IF EXISTS traductordb;
CREATE SCHEMA traductordb ;
CREATE USER IF NOT EXISTS app@'%' IDENTIFIED BY '0000';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'app'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

/*Exec App before continue*/

USE traductordb;
INSERT INTO rol(id, name, maxCharsPerParagraph, maxParagraphs, spanish, english, french) values 
	(1, 'Full', 1000, 20, true, true, true),
    (2, 'New', 100, 2, false, true, false),
    (3, 'English Lvl2', 500, 4, false, true, false),
    (4, 'English Lvl3', 1000, 20, false, true, false),
    (5, 'Spanish Lvl1', 100, 2, true, true, false),
    (6, 'Spanish Lvl2', 500, 4, true, true, false),
    (7, 'Spanish Lvl3', 1000, 20, true, true, false),
    (8, 'French Lvl1', 100, 2, false, true, true),
    (9, 'French Lvl2', 500, 4, false, true, true),
    (10, 'French Lvl3', 1000, 20, false, true, true);
INSERT INTO user(admin, nickname, password, rol_id) values (true, 'admin', '0000', 1), (false, 'user', '0000', 2);