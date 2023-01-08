import java.util.Queue;

public class PrintJob {
    Queue<PrintRequest> printRequests;


    public PrintJob(PrintRequest printRequest){
        printRequests.add(printRequest);
    }
    public void pullJob(){
        //do something to queue
    }

}

class PrioritySetting{
    public void changePriority(int priority){
        //increase priority of a job
    }
}