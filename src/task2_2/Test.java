package task2_2;

public class Test {

    public static void main(String[] args) {

        DebitAccount debitCard = new DebitAccount();
        debitCard.setBalance(1000);;
        debitCard.publisher.subscribe(new LogObserver());
        debitCard.publisher.subscribe(new EmailObserver());

        CreditAccount creditCard = new CreditAccount();
        creditCard.setBalance(1500);
        creditCard.setCreditLimit(1000);
        creditCard.publisher.subscribe(new LogObserver());
        creditCard.publisher.subscribe(new EmailObserver());


        System.out.println("Debit Account Info");
        try {

            debitCard.addMoney(1000);

        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        try {

            debitCard.withdrawMoney(900);

        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }


        System.out.println("Credit Account Info");
        try {

            creditCard.addMoney(50);

        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        try {

            creditCard.withdrawMoney(400);

        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        try {

            creditCard.withdrawMoney(400);

        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        try {

            creditCard.withdrawMoney(500);

        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }
}