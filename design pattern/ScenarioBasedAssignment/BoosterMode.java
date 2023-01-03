public class BoosterMode implements Interface{
    int intensityThreshold;
    int colorIntensity;

    public BoosterMode(int colorIntensity,int intensityThreshold){
        this.intensityThreshold=intensityThreshold;
        this.colorIntensity=colorIntensity;
    }
    public void doMode(){
        colorIntensity= colorIntensity*intensityThreshold;
    }
}