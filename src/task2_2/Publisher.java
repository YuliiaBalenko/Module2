package task2_2;

import java.util.ArrayList;

public class Publisher {
    ArrayList<Observer> subscribers = new ArrayList<>();

    public void subscribe(Observer subscriber) {
        subscribers.add(subscriber);
    }

    public void notifySubscriber(String message) {
        subscribers.forEach((i) -> i.update(message));
    }
}
