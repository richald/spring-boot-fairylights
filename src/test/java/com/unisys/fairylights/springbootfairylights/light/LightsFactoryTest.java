package com.unisys.fairylights.springbootfairylights.light;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LightsFactoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNoLights() {
        LightsFactory.lightsBuilder(0);
    }

    @Test
    public void shouldSetupFixedNumOfLights() {
        List<Light> fixedNumLights = LightsFactory.lightsFixedBuilder();

        assertEquals("number of lights should be " + LightsFactory.NUMBER_OF_LIGHTS, LightsFactory.NUMBER_OF_LIGHTS,
                fixedNumLights.size());
    }

    @Test
    public void shouldSetupInAlternatingColoursLights() {
        final int numberOfLights = 32;

        List<Light> lights = LightsFactory.lightsBuilder(numberOfLights);

        assertEquals(numberOfLights, lights.size());

        for (int i = 0; i < numberOfLights; i++) {
            assertEquals(LightColour.RED, lights.get(i++).getLightColour());

            if (i < numberOfLights) {
                assertEquals(LightColour.GREEN, lights.get(i++).getLightColour());
            }

            if (i < numberOfLights) {
                assertEquals(LightColour.WHITE, lights.get(i).getLightColour());
            }
        }

    }



}