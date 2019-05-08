package com.unisys.fairylights.springbootfairylights.light;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LightImplTest {
    @Test
    public void shouldPrintStatusOfRedLight() {
        LightImpl lightImp = new LightImpl(0, LightColour.RED);
        assertEquals( "Light 0 red off\n", lightImp.toString());

        lightImp.setLightStatus(LightStatus.ON);
        assertEquals( "Light 0 red on\n", lightImp.toString());
    }

    @Test
    public void shouldPrintStatusOfGreenLight() {
        LightImpl lightImp = new LightImpl(30, LightColour.GREEN);
        assertEquals( "Light 30 green off\n", lightImp.toString());

        lightImp.setLightStatus(LightStatus.ON);
        assertEquals( "Light 30 green on\n", lightImp.toString());
    }

    @Test
    public void shouldPrintStatusOfWhiteLight() {
        LightImpl lightImp = new LightImpl(10, LightColour.WHITE);
        assertEquals( "Light 10 white off\n", lightImp.toString());

        lightImp.setLightStatus(LightStatus.ON);
        assertEquals( "Light 10 white on\n", lightImp.toString());
    }
}
