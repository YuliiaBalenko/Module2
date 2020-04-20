package task2_2;

public class CreditAccount extends BankAccount {
    double balance;
    double creditLimit;
    double fee;
    public Publisher publisher;

    public CreditAccount() {
        this.publisher = new Publisher();
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public double addMoney(double amount) throws RuntimeException {
        if (amount <= 0)
            throw new RuntimeException("Unable to add money due to the invalid amount");

        double balanceBefore = balance;
        balance += amount;
        publisher.notifySubscriber("You added money on Credit account! Amount: $" + amount + " Initial Balance: $" + balanceBefore + " Current Balance: $" + balance);
        return balance;
    }

    @Override
    public double withdrawMoney(double amount) throws RuntimeException {
        if (amount <= 0)
            throw new RuntimeException("Unable to withdraw money due to the invalid amount");

        double amountFee = amount + calculateFee(amount);
        if (amountFee <= balance + creditLimit) {
            double balanceBefore = balance;
            balance -= amountFee;
            publisher.notifySubscriber(" Withdraw amount: $" + amount + " Initial Balance: $" + balanceBefore + " Current Balance: $" + balance);
        } else {
            publisher.notifySubscriber("Unable to withdraw $" + amount + " due to insufficient funds");
        }
        return balance;
    }

    @Override
    public double calculateFee(double amount) {
        if (balance >= amount)
            return amount * 0.01;

        if (balance <= 0)
            return amount * 0.05;

        return balance * 0.01 + (amount - balance) * 0.05;
    }
}
