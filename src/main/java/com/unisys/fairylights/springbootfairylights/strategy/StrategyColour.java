package com.unisys.fairylights.springbootfairylights.strategy;

import com.unisys.fairylights.springbootfairylights.light.Light;
import com.unisys.fairylights.springbootfairylights.light.LightColour;
import com.unisys.fairylights.springbootfairylights.light.LightImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * As required(colour):
 * all red lights are turned on for 1 second,
 * then all the green for 1 second
 * then all the white for 1 second
 * until the algorithm has been completed
 * and it should start again.
 */
public class StrategyColour extends AbstractStrategyImpl {

    public static final String NAME = "COLOUR";

    private boolean running = true;

    private static final int LITGHS_WAIT_TIME = 1000;

    private interface FilterPredicate<E> {
        boolean apply(E type);
    }

    @Override
    public void activateLigths(List<LightImpl> lights) {

        // List of colours
        List<LightColour> colours = Arrays.asList(LightColour.values());

        // List of sorted and coloured lights
        List<List<Light>> sortedLights = new ArrayList<>();

        for (final LightColour colour : colours) {


            List<Light> colouredLights = findLights(lights, new FilterPredicate<Light>() {

                @Override
                public boolean apply(Light light) {
                    return light.getLightColour() == colour;
                }
            });

            if (!colouredLights.isEmpty())
                sortedLights.add(colouredLights);
        }

        do{
            for (List<Light> list : sortedLights) {
                flash(list, LITGHS_WAIT_TIME);
            }
        }while(running);
    }

    private List<Light> findLights(List<LightImpl> lights, FilterPredicate<Light> predicate) {
        List<Light> coloredLights = new ArrayList<>();

        for (Light light : lights) {
            if (predicate.apply(light)) {
                coloredLights.add(light);
            }
        }

        return coloredLights;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
