package task2_2;

public abstract class BankAccount {
    double negativeFee = 0.05;
    double positiveFee = 0.01;
    public abstract double addMoney(double amount);
    public abstract double withdrawMoney(double amount);
}
