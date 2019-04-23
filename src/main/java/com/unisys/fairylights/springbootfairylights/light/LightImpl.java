package com.unisys.fairylights.springbootfairylights.light;

public class LightImpl implements Light {

    private LightStatus lightStatus;
    private LightColour lightColour;
    private int id;

    public LightImpl(int id, LightColour lightColour) {
        this.id = id;
        this.lightColour = lightColour;
        this.lightStatus = LightStatus.OFF;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LightStatus getLightStatus() {
        return lightStatus;
    }

    public void setLightStatus(LightStatus lightStatus) {
        this.lightStatus = lightStatus;
    }

    public void changeLightStatus(LightStatus newStatus){
        this.setLightStatus(newStatus);
    }

    @Override
    public LightColour getLightColour() {
        return lightColour;
    }

    public void setLightColour(LightColour lightColour) {
        this.lightColour = lightColour;
    }

    @Override
    public String toString() {
        return String.format("Light %s %s %s\n", this.id, this.lightColour.name().toLowerCase(), this.lightStatus.name().toLowerCase());
    }

}
