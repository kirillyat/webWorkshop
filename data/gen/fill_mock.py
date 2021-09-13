from random import randint
from mimesis import Person, Generic, locales, Address
from mimesis.enums import Gender
from mimesis.builtins import RussiaSpecProvider

def id_factory():
    num = 0
    while True:
        yield num
        num += 1

gen_id_m = id_factory()
gen_id_p = id_factory()

p = open("people.csv",  'w')
m = open("marrige.csv", 'w')

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



def makePopulation(f, n):
    for i in range(0,n,2):
        S = str(i) + '|' + makeManName() + '|'
        S+= str(randint(0,i)) + '|'+ str(randint(0,i)) + '|'
        S+= str(g.datetime.date()) + '|\\N|'
        S+= ru.generate_sentence() + '"|'
        S+= a.address()+'\n'
        f.write(S)
        S = str(i+1) + '|' + makeWomanName() + '|'
        S+= str(randint(0,i)) + '|'+ str(randint(0,i)) + '|'
        S+= str(g.datetime.date()) + '|\\N|'
        S+= ru.generate_sentence() + '"|'
        S+= a.address()+'\n'
        f.write(S)

def makeMarrige(f, n):
    for i in range(n):
        S = str(i) + '|'
        S+= str(randint(0,n-1)) + '|'+ str(randint(0,n-1)) + '|'
        S+= str(g.datetime.date()) + '|' + str(g.datetime.date()) +'\n'
        f.write(S)

n = 1000
makePopulation(p, n)
makeMarrige(m, n)

p.close()
m.close()
