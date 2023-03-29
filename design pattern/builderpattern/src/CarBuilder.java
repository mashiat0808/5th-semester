public class CarBuilder {
    private int id;
    private String brand;
    private String model;
    private String color;

    public CarBuilder id(int id){
        this.id=id;
    }

    public CarBuilder brand(String brand){
        this.brand=brand;
    }

    public CarBuilder model(String model){
        this.model=model;
    }

    public CarBuilder color(String color){
        this.color=color;
    }

    public Car build()
    {
        return new Car(id, brand, model, color);
    }
}
