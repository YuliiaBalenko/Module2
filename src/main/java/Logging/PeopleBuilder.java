package Logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class PeopleBuilder {

    private static Logger log = LogManager.getLogger(PeopleBuilder.class);

    private static int countPerson = 0;
    private static String NAMES[] = {"Julia", "Lisa", "Denis", "Milana", "Diana"};
    private static String SURNAMES[] = {"Balenko", "Babkin", "Habib"};
    private static Random random = new Random();

    public static Person create(int hobbyAmount, int childrenAmount, int petAmount)
    {
        String name = createRandomName();
        String surname = createRandomSurname();
        Person.GenderTypes gender = createRandomGender();
        String id = String.valueOf(countPerson++);


        Person person = new Person(id, name, surname, gender);
        createRandomHobbies(person, hobbyAmount);
        createRandomChildren(person, childrenAmount);
        createRandomPets(person, petAmount);

        return person;
    }

    private static void createRandomChildren(Person person, int childrenAmount) {

        if(childrenAmount < 1)
            log.warn("Warning: children amount must be more 0, current value = " + childrenAmount);

        for (int i = 0; i < childrenAmount; i++) {
            person.addChild(createChild(person.getSurname()));
        }
    }

    private static void createRandomPets(Person person, int petAmount) {
        if(petAmount < 1)
            log.warn("Warning: pet amount must be more 0, current value = " + petAmount);

        for (int i = 0; i < petAmount; i++) {
            person.addPet(createPet());
        }
    }

    private static void createRandomHobbies(Person person, int hobbyAmount) {
        if(hobbyAmount < 1)
            log.warn("Warning: hobby amount must be more 0, current value = " + hobbyAmount);

        for (int i = 0; i < hobbyAmount; i++) {
            person.addHobby(createHobby());
        }
    }

    private static Person.PetTypes createPet() {
        switch (random.nextInt(Person.PetTypes.values().length))
        {
            case 0:
            {
                return Person.PetTypes.cat;
            }
            case 1:
            {
                return Person.PetTypes.dog;
            }
            case 2:
            {
                return Person.PetTypes.hamster;
            }
            default:
            {
                return Person.PetTypes.parrot;
            }
        }
    }

    private static Person.HobbyTypes createHobby() {
        switch (random.nextInt(Person.HobbyTypes.values().length))
        {
            case 0:
            {
                return Person.HobbyTypes.sport;
            }
            case 1:
            {
                return Person.HobbyTypes.watchingTV;
            }
            case 2:
            {
                return Person.HobbyTypes.fishing;
            }
            default:
            {
                return Person.HobbyTypes.dancing;
            }
        }
    }


    private static Person createChild(String surname) {
        String name = createRandomName();
        Person.GenderTypes gender = createRandomGender();


        Person person = new Person(String.valueOf(++countPerson), name, surname, gender);
        return person;
    }

    private static String createRandomName() {
        return NAMES[random.nextInt(NAMES.length - 1)];
    }

    private static String createRandomSurname() {
        return SURNAMES[random.nextInt(SURNAMES.length - 1)];
    }

    private static Person.GenderTypes createRandomGender() {
        switch (random.nextInt(Person.GenderTypes.values().length))
        {
            case 0:
            {
                return Person.GenderTypes.male;
            }
            case 1:
            {
                return Person.GenderTypes.female;
            }
            default:
            {
                return Person.GenderTypes.middleSex;
            }
        }
    }
}
