from random import randint
from mimesis import Person, Generic, locales, Address
from mimesis.enums import Gender
from mimesis.builtins import RussiaSpecProvider


p = open("people.csv",  'w')
m = open("merrige.csv", 'w')

#Objects for mimesis
person = Person(locales.RU)
ru = RussiaSpecProvider()
g = Generic('ru')
a = Address('ru')

def makeManName():
    return str(person.full_name(gender=Gender.MALE)
            + " " +
            ru.patronymic(gender=Gender.MALE))

def makeWomanName():
    return  str(person.full_name(gender=Gender.FEMALE)
            + " " +
            ru.patronymic(gender=Gender.FEMALE))


'''
id UInt64,              -- Индефикатор
name String,            -- ФИО
mother_id UInt64,       -- ID Матери
father_id UInt64,       -- ID Отца
birth_date Date,        -- Дата рождения
death_date Date NULL,   -- Дата смерти | NULL
description String,     -- Описание
address String,         -- Места проживания
'''
def makePopulation(f, n):
    for i in range(0,n,2):
        S = str(i) + '|' + makeManName() + '|'
        S+= str(randint(0,i)) + '|'+ str(randint(0,i)) + '|'
        S+= str(g.datetime.date()) + '|' + '|'
        S+= ru.generate_sentence() + '|'
        S+= a.address()+'\n'
        f.write(S)
        S = str(i+1) + '|' + makeWomanName() + '|'
        S+= str(randint(0,i)) + '|'+ str(randint(0,i)) + '|'
        S+= str(g.datetime.date()) + '|' + '|'
        S+= ru.generate_sentence() + '|'
        S+= a.address()+'\n'
        f.write(S)

def makeMarrige(f, n):
    for i in range(n):
        S= str(randint(0,n)) + '|'+ str(randint(0,n)) + '|'
        S+= str(g.datetime.date()) + '|' + str(g.datetime.date()) +'\n'
        f.write(S)

n = 100
makePopulation(p, n)
makeMarrige(m, n)

p.close()
m.close()
