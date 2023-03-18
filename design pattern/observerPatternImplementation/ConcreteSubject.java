import java.io.File;
import java.util.Date;

class ConcreteSubject extends Subject {
    private String filePath;
    private long fileLastModified;

    public ConcreteSubject(String filePath) {
        this.filePath = filePath;
        this.fileLastModified = new File(filePath).lastModified();
    }

    public void monitorFile() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            File file = new File(filePath);
            long newFileLastModified = file.lastModified();

            if (newFileLastModified != fileLastModified) {
                fileLastModified = newFileLastModified;
                notifyObservers();
            }
        }
    }
}
