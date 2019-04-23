package com.unisys.fairylights.springbootfairylights.light;

import java.util.ArrayList;
import java.util.List;

public class LightsFactory {

    public static final int NUMBER_OF_LIGHTS = 20;

    /**
     * Building lights given number of lights
     * @param numberOfLights
     * @return List of lights
     */
    public static List<LightImpl> lightsBuilder(int numberOfLights) {

        LightColour[] listColours = LightColour.values();

        List<LightImpl> lights = new ArrayList<>();

        for (int j = 0; j < numberOfLights; j++) {
            lights.add(new LightImpl(j + 1, listColours[j % listColours.length]));
        }

        return lights;
    }

    /**
     * Building lights of fixed number of provided(20)
     * @return List of lights
     */
    public static List<LightImpl> lightsFixedBuilder() {
        return lightsBuilder(NUMBER_OF_LIGHTS);
    }

}
