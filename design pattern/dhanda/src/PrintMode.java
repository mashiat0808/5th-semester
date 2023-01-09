
abstract class PrintMode {
    private int numPages;
    private int pageSize;
    private String orientation;
    private int colorIntensity;
    private double costPerPage;

    public abstract void save();

    // Getter and setter methods for the fields go here
}

class TonerSaveMode extends PrintMode {
    private String tonerSavingLevel;
    private ITonerSaveMode tonerSaveMode;
    public void setTonerSavingLevel(String tonerSavingLevel, ITonerSaveMode tonerSaveMode)
    {
        this.tonerSavingLevel=tonerSavingLevel;
        this.tonerSaveMode= tonerSaveMode;
    }
    @Override
    public void save() {
        tonerSaveMode.algorithm();
    }


    // Getter and setter method for tonerSavingLevel go here
}