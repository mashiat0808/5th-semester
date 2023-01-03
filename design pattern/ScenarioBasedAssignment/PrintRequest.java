import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrintRequest {
    private Document document;
    private ArrayList<Interface> modes;
    public PrintRequest(Document document, ArrayList<Interface>modes){
        for(Interface mode:modes){
            modes.add(mode);
        }
        this.document=document;
    }

}

class Document{

    public void readDocument(){

    }
}