package com.unisys.fairylights.springbootfairylights.light;

public interface Light {

    int getId();

    void setLightStatus(LightStatus lightStatus);

    LightStatus getLightStatus();

    void changeLightStatus(LightStatus newStatus);

    LightColour getLightColour();

    void setLightColour(LightColour newColour);
}
