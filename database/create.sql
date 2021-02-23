CREATE TABLE people (
	id UInt64, 				-- Индефикатор
	name String, 			-- ФИО
	mother_id UInt64, 		-- ID Матери
	father_id UInt64, 		-- ID Отца
	birth_date Date, 		-- Дата рождения
	death_date Date NULL,	-- Дата смерти | NULL
	description String,		-- Описание
							-- TODO: Места проживания
    
	PRIMARY KEY(id)
);


CREATE TABLE marriage (
	wife_id UInt64, 		-- ID Супрги
	husband_id UInt64, 		-- ID Супруга
	marriage_date Date, 	-- Дата заключения брака
	divorce_date Date NULL 	-- Дата расторжения брака | NULL
);



