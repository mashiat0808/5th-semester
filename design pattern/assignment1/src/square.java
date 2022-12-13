public class square implements shape{
    int size;
    public square(int size)
    {
        this.size=size;
    }
    public int getArea(){
        return this.size*this.size;
    }
    public void setColor(int color){
        System.out.println("Color set");
    }
    public void draw(){

    }

}
