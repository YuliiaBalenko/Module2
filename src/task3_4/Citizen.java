package task3_4;

public class Citizen {
    public String name;
    public String surname;
    public String id;

    public Citizen(String name, String surname, Passport passport)
    {
        this.name = name;
        this.surname = surname;
        this.id = passport.getFullId();
    }

    public String getFullName() {
        return this.name + this.surname;
    }

}
