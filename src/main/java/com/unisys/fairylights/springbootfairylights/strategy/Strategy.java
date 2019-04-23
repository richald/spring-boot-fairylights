package com.unisys.fairylights.springbootfairylights.strategy;

import com.unisys.fairylights.springbootfairylights.light.LightImpl;

import java.util.List;

public interface Strategy {
    void activateLigths(List<LightImpl> lights);
}
