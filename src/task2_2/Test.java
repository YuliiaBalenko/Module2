package task2_2;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        try {
            System.out.println("Debit Account Info");
            DebitAccount debitCard = new DebitAccount();
            debitCard.setBalance(1000);
            debitCard.publisher.subscribe(new LogObserver());
            debitCard.publisher.subscribe(new EmailObserver());
            debitCard.withdrawMoney(1010);
            debitCard.addMoney(10);

            System.out.println("Credit Account Info");
            CreditAccount creditCard = new CreditAccount();
            creditCard.setBalance(1000);
            creditCard.publisher.subscribe(new LogObserver());
            creditCard.publisher.subscribe(new EmailObserver());
            creditCard.withdrawMoney(1100);
            creditCard.addMoney(50);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }
}