package com.unisys.fairylights.springbootfairylights.strategy;

import com.unisys.fairylights.springbootfairylights.light.Light;
import com.unisys.fairylights.springbootfairylights.light.LightStatus;

import java.util.List;

public abstract class AbstractStrategyImpl implements Strategy {

    protected void delay(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * For a given time; all lights are being flashed.
     * @param lights
     * @param delay
     */
    protected void flash(List<Light> lights, int delay) {
        changeStatus(lights, LightStatus.ON);
        this.delay(delay);
        changeStatus(lights, LightStatus.OFF);
    }

    /**
     * For a given time; one light is flashed.
     * @param light
     * @param delay
     */
    protected void flash(Light light, int delay) {
        changeStatus(light, LightStatus.ON);
        this.delay(delay);
        changeStatus(light, LightStatus.OFF);
    }

    /**
     * For a given status; all lights change the status.
     *
     */
    private void changeStatus(List<Light> lights, LightStatus lightStatus) {
        for (Light light : lights) {
            light.changeLightStatus(lightStatus);
        }
    }

    /**
     * For a given status; one light changes the status.
     *
     */
    private void changeStatus(Light light, LightStatus lightStatus) {
        light.changeLightStatus(lightStatus);
        System.out.print(light);
    }

}
