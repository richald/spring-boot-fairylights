package com.unisys.fairylights.springbootfairylights.strategy;

import com.unisys.fairylights.springbootfairylights.light.Light;

import java.util.List;

public interface Strategy {
    void activateLigths(List<Light> lights);
}
