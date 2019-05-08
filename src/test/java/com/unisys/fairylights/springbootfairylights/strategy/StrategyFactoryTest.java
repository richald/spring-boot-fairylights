package com.unisys.fairylights.springbootfairylights.strategy;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StrategyFactoryTest {
    @Test
    public void shouldGetObjectForValidNameSequence() {
        Strategy instance = StrategyFactory.getStrategy("SEQUENCE");
        assertNotNull("SequenceStrategy expected ", instance);
    }


    @Test
    public void shouldGetObjectForValidNameColour() {
        Strategy instance = StrategyFactory.getStrategy("Colour" );
        assertNotNull("StrategyColour expected", instance);
    }


    @Test
    public void shouldTrimNameOfStrategy() {
        Strategy instance = StrategyFactory.getStrategy( StrategyColour.NAME + "   ");
        assertNotNull("StrategyColour algorithm expected", instance);
    }

    @Test
    public void shouldIgnoreCaseWhenMatchingStrategy() {
        Strategy instance = StrategyFactory.getStrategy( StrategyColour.NAME.toLowerCase());
        assertNotNull("StrategyColour algorithm expected", instance);
    }
}
