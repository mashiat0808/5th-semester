public class TonerSaveMode implements Interface{
    int colorIntensity;
    TonerSavingLevel tonerSavingLevel;

    public TonerSaveMode(int colorIntensity){
        this.colorIntensity=colorIntensity;
    }

    public void setMode(int colorIntensity, TonerSavingLevel tonerSavingLevel){
        this.colorIntensity=colorIntensity;
        this.tonerSavingLevel=tonerSavingLevel;
    }
    public void doMode(){
        colorIntensity=tonerSavingLevel.algorithm(colorIntensity);
    }

}