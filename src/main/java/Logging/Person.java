package Logging;

import java.util.ArrayList;

public class Person {

    public enum GenderTypes {
        male, female, middleSex
    }

    public enum PetTypes {
        cat, dog, hamster, parrot
    }

    public enum HobbyTypes {
        sport, watchingTV, fishing, dancing
    }

    private String id;
    private String name;
    private String surname;
    private ArrayList<Person> children;
    private GenderTypes gender;
    private ArrayList<PetTypes> pets;
    private ArrayList<HobbyTypes> hobbies;

    public Person(String id, String name, String surname, GenderTypes gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;

        children = new ArrayList<>();
        pets = new ArrayList<>();
        hobbies = new ArrayList<>();
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public String getSurname() {
        return surname;
    }

    public GenderTypes getGender() {
        return gender;
    }

    public ArrayList<PetTypes> getPets() {
        return pets;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public ArrayList<HobbyTypes> getHobby() {
        return hobbies;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public void addHobby(HobbyTypes hobby) {
        hobbies.add(hobby);
    }

    public void addPet(PetTypes pet) {
        pets.add(pet);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", children=" + children +
                ", hobby='" + hobbies + '\'' +
                ", gender=" + gender +
                ", pets=" + pets +
                ", hobbies=" + hobbies +
                '}';
    }
}
