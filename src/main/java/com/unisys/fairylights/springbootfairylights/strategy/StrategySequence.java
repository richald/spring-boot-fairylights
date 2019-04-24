package com.unisys.fairylights.springbootfairylights.strategy;

import com.unisys.fairylights.springbootfairylights.light.Light;
import com.unisys.fairylights.springbootfairylights.light.LightImpl;

/**
 * As required(sequence)
 * Each light is turned on for 0.5 seconds
 * then off for 0.5 seconds
 * from first to last.
 * until the algorithm has been completed
 * and it should start again.
 */
import java.util.List;

public class StrategySequence extends AbstractStrategyImpl {

    public static final String NAME = "SEQUENCE";

    private static final int LITGHS_WAIT_TIME = 500;


    private boolean running = true;

    @Override
    public void activateLigths(List<Light> lights) {
        do {
            displayLights(lights);
        } while (running);
    }

    private void displayLights(List<Light> lights) {
        for (Light light : lights) {
            flash(light, LITGHS_WAIT_TIME);
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

}
