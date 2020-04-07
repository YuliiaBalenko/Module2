package task2_2;

public class CreditAccount extends BankAccount {
    double balance;
    public Publisher publisher;

    public CreditAccount() {
        this.publisher = new Publisher();
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public double addMoney(double amount) throws RuntimeException {
        balance += amount;
        if (amount < 0) {
            throw new RuntimeException("Not valid amount");
        }
        publisher.notifySubscriber("You added money on Credit account! Amount: $" + amount + " Current Balance: $" + balance);

        return balance;
    }

    @Override
    public double withdrawMoney(double amount) {
        if (balance >= amount) {
            balance = balance - amount - amount*positiveFee;
            publisher.notifySubscriber(" Withdraw amount: $" + amount + " Current Balance: $" + balance);
        }
        else {
            balance = balance - amount - amount * negativeFee;
            publisher.notifySubscriber(" Withdraw amount: $" + amount + " Current Balance: $" + balance);
        }
        return balance;
    }
}
