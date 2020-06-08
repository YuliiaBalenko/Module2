package Logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Test {

    private static Logger log = LogManager.getLogger(Test.class);
    private static Person personList[];
    private static Random random = new Random();

    public static void main(String[] args) {

        int personAmount = 10;
        personList = new Person[personAmount];
        for (int i = 0; i < personAmount; i++) {
            int childrenAmount = random.nextInt(5) - 2;
            int petAmount = random.nextInt(5) - 2;
            int hobbyAmount = random.nextInt(5) - 1;

            Person person = PeopleBuilder.create(childrenAmount, petAmount, hobbyAmount);
            personList[i] = person;
            addToLogNewPerson(person);
        }

        stats();
    }

    private static void addToLogNewPerson(Person person) {
        log.log(Level.getLevel("INFO"), person.toString());
    }

    private static void stats() {
        addToStats(" STATISTICS ");
        addToStats("person count: " + personList.length);
        addToStats("male count: " + getMaleCount(Person.GenderTypes.male));
        addToStats("female count: " + getMaleCount(Person.GenderTypes.female));
        addToStats("person with children: " + getChildrenCount(1));
        addToStats("person with children more than 2: " + getChildrenCount(2));
        addToStats("child boy count: " + getChildrenCountByGender(Person.GenderTypes.male));
        addToStats("person with cat: " + getPersonWithAnimalsCountByType(Person.PetTypes.cat));
        addToStats("person with parrot: " + getPersonWithAnimalsCountByType(Person.PetTypes.parrot));
        addToStats("person with dancing hobby: " + getPersonWithHobbyCountByType(Person.HobbyTypes.dancing));
    }

    private static int getChildrenCountByGender(Person.GenderTypes gender) {
        int count = 0;
        for (Person person : personList) {
            if (person.getChildren().size() > 0) {
                for (Person child : person.getChildren()) {
                    if (child.getGender() == gender)
                        count++;
                }
            }
        }
        return count;
    }

    private static int getChildrenCount(int childrenAmount) {
        int count = 0;
        for (Person person : personList) {
            if (person.getChildren().size() >= childrenAmount)
                count += person.getChildren().size();
        }
        return count;
    }

    private static int getMaleCount(Person.GenderTypes gender) {
        int count = 0;
        for (Person person : personList) {
            if (person.getGender() == gender)
                count++;
        }
        return count;
    }


    private static int getPersonWithAnimalsCountByType(Person.PetTypes type) {
        int count = 0;
        for (Person person : personList) {
            if (person.getPets().indexOf(type) != -1)
                count++;
        }
        return count;
    }

    private static int getPersonWithHobbyCountByType(Person.HobbyTypes type) {
        int count = 0;
        for (Person person : personList) {
            if (person.getHobby().indexOf(type) != -1)
                count++;
        }
        return count;
    }

    private static void addToStats(String value) {
        log.log(Level.getLevel("CUSTOMER"), value);
    }
}
