package com.unisys.fairylights.springbootfairylights.strategy;

import com.unisys.fairylights.springbootfairylights.light.Light;
import com.unisys.fairylights.springbootfairylights.light.LightImpl;

import java.util.List;
import java.util.Random;

/**
 * Displays an additional random light.
 */
public class StrategyRandom extends AbstractStrategyImpl {

    public static final String NAME = "RANDOM";

    private static final int LITGHS_WAIT_TIME = 500;

    /**
     *  Displays a single random light.
     */
    @Override
    public void activateLigths(List<Light> lights) {

        int nextRandomNumber = new Random().nextInt(lights.size() - 1);

        Light fairyLight = lights.get(nextRandomNumber);

        flash(fairyLight, LITGHS_WAIT_TIME);
    }

}
