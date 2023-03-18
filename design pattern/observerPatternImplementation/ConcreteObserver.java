import java.io.File;
import java.util.Date;

class ConcreteObserver implements Observer {
    private String observerName;
    private ConcreteSubject concreteSubject;

    public ConcreteObserver(String observerName, ConcreteSubject concreteSubject) {
        this.observerName = observerName;
        this.concreteSubject = concreteSubject;
    }

    public void update() {
        System.out.println(observerName + " notified: File " + concreteSubject.filePath + " has been modified at " + new Date(concreteSubject.fileLastModified));
    }
}