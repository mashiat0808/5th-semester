
public class App {
    public static void main(String args[]){
        Animal A = new Animal(2,2,2);
        System.out.println(A.legs);
        A.legs= 5;
        System.out.println(A.legs);

    }

}

class Animal{
    private int legs;
   private int shing;
   private int weight;

   public void eat(){
       System.out.println("nomnom");
   }
   public void call(){
       System.out.println("animal call");
   }

   Animal(int paa, int horn, int w){
       this.legs= paa;
       this.shing= horn;
       this.weight= w;
   }

    public int getLegs() {
        return legs;
    }
    public void setLegs(int legs) {
        this.legs = legs;
    }
}

