public class Main {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject("test.txt");
        ConcreteObserver observer1 = new ConcreteObserver("Observer 1", concreteSubject);
        ConcreteObserver observer2 = new ConcreteObserver("Observer 2", concreteSubject);

        concreteSubject.register(observer1);
        concreteSubject.register(observer2);

        concreteSubject.monitorFile();
    }
}