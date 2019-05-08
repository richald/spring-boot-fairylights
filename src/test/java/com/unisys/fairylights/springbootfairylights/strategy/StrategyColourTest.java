package com.unisys.fairylights.springbootfairylights.strategy;

import com.unisys.fairylights.springbootfairylights.light.Light;
import com.unisys.fairylights.springbootfairylights.light.LightsFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StrategyColourTest {
    private FakeStrategyColour strategyColour;

    private class FakeStrategyColour extends StrategyColour {

        @Override
        protected void delay(long time) {
            super.delay(time);
            assertEquals("Delay should be of 1000 milli seconds.", 1000, time);
        }

        @Override
        protected void flash(List<Light> lights, int delay) {
            super.flash(lights, delay);
            flashListCount++;
        }


        public int getFlashListCount() {
            return flashListCount;
        }

        private int flashListCount;
    }

    @Test
    public void shouldDelayFlashFor1000() throws Exception {

        strategyColour.activateLigths(LightsFactory.lightsBuilder(1));

        // assert(test) in fake class
    }

    @Test
    public void shouldCallFlashMethodTwice() throws Exception {

        strategyColour.activateLigths(LightsFactory.lightsBuilder(2));

        assertEquals("Should have called flash twice ", 2, strategyColour.getFlashListCount());
    }


    @Before
    public void setUp() {

        strategyColour = new FakeStrategyColour();
        strategyColour.setRunning(false);
    }

    @After
    public void cleanUp() {
        strategyColour = null;
    }

}
