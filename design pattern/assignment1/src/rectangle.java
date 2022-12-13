public class rectangle implements shape{
    int height, width;
    public rectangle(int height,int width){
        this.height=height;
        this.width=width;
    }
    public int getArea(){
        return this.height*this.width;
    }
    public void setColor(int color){
        System.out.println("Color set");
    }
    public void draw(){

    }


}
