package task3_4;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<Passport, Citizen> citizens = new HashMap<>();

        Passport pspOne = new Passport("SV", "123456");
        Citizen ctzOne = new Citizen("Ivan", "Ivanov", pspOne);
        citizens.put(pspOne, ctzOne);

        Passport pspTwo = new Passport("VS", "654321");
        Citizen ctzTwo = new Citizen("Sidor", "Sidorov", pspTwo);
        citizens.put(pspTwo, ctzTwo);

        Passport pspThree = new Passport("XX", "567890");
        Citizen ctzThree = new Citizen("Petr", "Petrov", pspThree);
        citizens.put(pspThree, ctzThree);

        citizens.forEach((psp,ctz) ->
                System.out.println("PSP => " + psp.getFullId() + " CTZ => " + ctz.getFullName()));

    }
}
