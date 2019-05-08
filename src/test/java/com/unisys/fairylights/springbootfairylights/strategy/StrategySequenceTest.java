package com.unisys.fairylights.springbootfairylights.strategy;

import com.unisys.fairylights.springbootfairylights.light.Light;
import com.unisys.fairylights.springbootfairylights.light.LightsFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrategySequenceTest {

    private FakeStrategySequence strategySequence;

    private class FakeStrategySequence extends StrategySequence {

        @Override
        protected void delay(long time) {
            super.delay(time);
            assertEquals("Delay should be of 500 milli seconds.", 500, time);
        }

        @Override
        protected void flash(Light light, int delay) {
            super.flash(light, delay);
            flashCount++;
        }

        public int getFlashCount() {
            return flashCount;
        }

        private int flashCount;

    }

    @Test
    public void shouldDelayFlashFor500() throws Exception {

        strategySequence.activateLigths(LightsFactory.lightsBuilder(1));

        // assert(test) in fake class
    }

    @Test
    public void shouldCallFlashMethodTwice() throws Exception {

        strategySequence.activateLigths(LightsFactory.lightsBuilder(2));

        assertEquals("Should have called flash twice ", 2, strategySequence.getFlashCount());
    }


    @Before
    public void setUp() {

        strategySequence = new FakeStrategySequence();
        strategySequence.setRunning(false);
    }

    @After
    public void cleanUp() {
        strategySequence = null;
    }

}
