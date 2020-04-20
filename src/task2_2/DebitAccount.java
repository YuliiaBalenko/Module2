package task2_2;

public class DebitAccount extends BankAccount {
    double balance;
    double fee;
    public Publisher publisher;

    public DebitAccount() {
        this.publisher = new Publisher();
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public double addMoney(double amount) throws RuntimeException {
        if (amount > 0) {
            balance += amount;
        } else
            throw new RuntimeException("Unable to add money due to the invalid amount");
        publisher.notifySubscriber("You added money on Debit account! Amount: $" + amount + " Initial Balance: $" + balance + " Current Balance: $" + balance);

        return balance;
    }

    @Override
    public double withdrawMoney(double amount) throws RuntimeException {
        if(amount <= 0)
            throw new RuntimeException("Unable to withdraw money due to the invalid amount");

        double amountFee = amount + calculateFee(amount);
        if(amountFee <= balance){
            double balanceBefore = balance;
            balance -= amountFee;
            publisher.notifySubscriber(" Withdraw amount: $" + amount + " Initial Balance: $" + balanceBefore + " Current Balance: $" + balance);
        }
        else {
            publisher.notifySubscriber("Unable to withdraw $" + amount + " due to insufficient funds");
        }
        return balance;
    }

    @Override
    public double calculateFee(double amount) {
            fee = 0.01 * amount;
        return fee;
    }
}
