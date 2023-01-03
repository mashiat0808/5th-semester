public interface TonerSavingLevel {
    public int algorithm(int colorIntensity);
}
class HighToner implements TonerSavingLevel{

    public int algorithm(int colorIntensity){
        return colorIntensity;
    }
}
class MediumToner implements TonerSavingLevel{
    public int algorithm(int colorIntensity){
        return colorIntensity;
    }
}
class LowToner implements TonerSavingLevel{
    public int algorithm(int colorIntensity){
        return colorIntensity;
    }
}