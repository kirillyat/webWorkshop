DROP TABLE IF EXISTS people;
DROP TABLE IF EXISTS marriage;

DROP DATABASE IF EXISTS FamilyTree;
CREATE DATABASE FamilyTree;
\connect FamilyTree

CREATE TABLE people (
    id UInt64,              -- Индефикатор
    name String,            -- ФИО
    mother_id UInt64        -- ID Матери
    REFERENCES people(id),
    father_id UInt64        -- ID Отца
    REFERENCES people(id),
    birth_date Date,        -- Дата рождения
    death_date Date NULL,   -- Дата смерти | NULL
    description String,     -- Описание
    address String,         -- Места проживания

    PRIMARY KEY(id)
);


CREATE TABLE marriage (
    wife_id UInt64,         -- ID Супрги
    husband_id UInt64,      -- ID Супруга
    marriage_date Date,     -- Дата заключения брака
    divorce_date Date NULL, -- Дата расторжения брака | NULL

    FOREIGN KEY(wife_id)
    REFERENCES people(id),

    FOREIGN KEY(husband_id)
    REFERENCES people(id),
);
