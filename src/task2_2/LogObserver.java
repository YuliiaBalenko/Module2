package task2_2;

public class LogObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("[INFO] => " + message);
    }
}
