CREATE TABLE people (
    id Serial,              -- Индефикатор
    name varchar(50),            -- ФИО
    mother_id integer null,       -- ID Матери
    --REFERENCES people(id) NULL,
    father_id integer null,       -- ID Отца
    --REFERENCES people(id) NULL ,
    birth_date Date NULL,        -- Дата рождения
    death_date Date NULL,   -- Дата смерти | NULL
    description text NULL,     -- Описание
    address varchar(50) NULL,         -- Места проживания

    PRIMARY KEY(id)
);


CREATE TABLE marrige (
    id Serial,              -- ID Свадьбы
    wife_id integer NULL,         -- ID Супрги
    husband_id integer NULL,      -- ID Супруга
    marrige_date Date NULL,     -- Дата заключения брака
    divorce_date Date NULL, -- Дата расторжения брака | NULL

    --FOREIGN KEY(wife_id) REFERENCES people(id),
    --FOREIGN KEY(husband_id) REFERENCES people(id),

    PRIMARY KEY(id)
);



--COPY people FROM '/Users/kirillyat/Developer/webWorkshop/database/people.csv' DELIMITER '|';

--COPY marriage FROM '/Users/kirillyat/Developer/webWorkshop/database/merrige.csv' DELIMITER '|';