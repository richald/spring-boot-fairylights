package com.unisys.fairylights.springbootfairylights.strategy;

import com.unisys.fairylights.springbootfairylights.util.Alerts;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory class to return Strategy.
 */
public class StrategyFactory {

    private static final Map<String, Strategy> SUPPORTED_STRATEGIES;
    private static final String NOT_STRATEGIES = "Exception.UnknownStrategy";

    //build a map of available algorithms
    static {
        SUPPORTED_STRATEGIES = new HashMap<String, Strategy>();
        SUPPORTED_STRATEGIES.put(StrategySequence.NAME, new StrategySequence());
        SUPPORTED_STRATEGIES.put(StrategyColour.NAME, new StrategyColour());
        /**********************************************************
         *  use RandomStrategySample to add new strategies
         ****************************/
        SUPPORTED_STRATEGIES.put(StrategyRandom.NAME, new StrategyRandom());
    }

    /**
     * Returns instance of {@link Strategy}
     * @param strategyName
     * @return Strategy
     * @throws IllegalArgumentException if the strategy with the given name doesn't exist.
     */
    public static Strategy getStrategy(String strategyName) {
        if (strategyName == null || !SUPPORTED_STRATEGIES.containsKey(strategyName.trim().toUpperCase())) {
            throw new IllegalArgumentException(Alerts.getString(NOT_STRATEGIES) + " : " + strategyName) ;
        }
        return SUPPORTED_STRATEGIES.get(strategyName.trim().toUpperCase());
    }

}
