
import random
from mimesis import Person, Generic, locales
from mimesis.enums import Gender
from mimesis.builtins import RussiaSpecProvider

person = Person(locales.RU)
ru = RussiaSpecProvider()
g = Generic('ru')

def makeMan():
    print(person.full_name(gender=Gender.MALE)+" "+
          ru.patronymic(gender=Gender.MALE))
    print(g.datetime.date())
    print(ru.generate_sentence())

def makeWoman():
    print(person.full_name(gender=Gender.FEMALE)+ " " +ru.patronymic(gender=Gender.FEMALE))
    print(g.datetime.date())

def marrige():
    print("hello")


makeMan()