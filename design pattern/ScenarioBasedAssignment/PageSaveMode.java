public class PageSaveMode implements Interface{
    int pageSize;
    int orientation;
    public PageSaveMode(int pageSize,int orientation){
        this.pageSize=pageSize;
        this.orientation=orientation;
    }

    public void algorithm(){
        //do something to pageSize and orientation
    }
    public void renderPreview(){

    }
    public void doMode(){
        algorithm();
        renderPreview();
    }
}