
DROP DATABASE IF EXISTS posgres;
CREATE DATABASE posgres;

DROP TABLE IF EXISTS marriage;
DROP TABLE IF EXISTS people;


CREATE TABLE people (
    id integer,              -- Индефикатор
    name varchar(50),            -- ФИО
    mother_id integer        -- ID Матери
    REFERENCES people(id),
    father_id integer        -- ID Отца
    REFERENCES people(id),
    birth_date Date,        -- Дата рождения
    death_date Date NULL,   -- Дата смерти | NULL
    description text,     -- Описание
    address varchar(50),         -- Места проживания

    PRIMARY KEY(id)
);


CREATE TABLE marriage (
    wife_id integer,         -- ID Супрги
    husband_id integer,      -- ID Супруга
    marriage_date Date,     -- Дата заключения брака
    divorce_date Date NULL, -- Дата расторжения брака | NULL

    FOREIGN KEY(wife_id)
    REFERENCES people(id),

    FOREIGN KEY(husband_id)
    REFERENCES people(id)
);



COPY people FROM '/Users/kirillyat/Developer/webWorkshop/database/people.csv' DELIMITER '|';

COPY marriage FROM '/Users/kirillyat/Developer/webWorkshop/database/merrige.csv' DELIMITER '|';