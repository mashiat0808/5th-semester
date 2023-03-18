import java.util.ArrayList;
import java.util.List;


    abstract class Subject {
        private List<Observer> registeredObservers = new ArrayList<Observer>();

        public void register(Observer observer) {
            registeredObservers.add(observer);
        }

        public void unregister(Observer observer) {
            registeredObservers.remove(observer);
        }

        public void notifyObservers() {
            for (Observer observer : registeredObservers) {
                observer.update();
            }
        }
    }