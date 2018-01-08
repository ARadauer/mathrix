package com.radauer.mathrix.example.at;

/**
 * Created by Andreas on 08.01.2018.
 */
public class Specification {
    private String modelCode;
    private String colorCode;
    private String[] optionCodes;

    public Specification(String modelCode, String colorCode, String... optionCodes) {
        this.modelCode = modelCode;
        this.colorCode = colorCode;
        this.optionCodes = optionCodes;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String[] getOptionCodes() {
        return optionCodes;
    }

    public void setOptionCodes(String[] optionCodes) {
        this.optionCodes = optionCodes;
    }
}
