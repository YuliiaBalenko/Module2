package task2_2;

public class EmailObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("This info [" + message + "] was successfully E-mailed!");
    }
}
