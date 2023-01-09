import java.util.Queue;

public class PrintJob {
    private Queue<PrintRequest> printRequestQueue;
    private PrioritySetting prioritySetting;

    public void addPrintRequest(Document document, PrintMode printMode) {
        // Add a new PrintRequest to the queue
        printRequestQueue.add(new PrintRequest(document, printMode));
    }
    public void pullJob() {
        // Send a specific job to production based on priority setting
    }

}
