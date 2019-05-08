package com.unisys.fairylights.springbootfairylights.strategy;

import com.unisys.fairylights.springbootfairylights.light.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class AbstractStrategyImplTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private StrategySequence strategySequence;
    private PrintStream original = System.out;

    @Before
    public void setUpStreams() {
        strategySequence = new StrategySequence();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        strategySequence = null;
        System.setOut(original);
    }

    @Test
    public void shouldChangeLightStatus() throws Exception {
        // Arrange
        Method method = AbstractStrategyImpl.class.getDeclaredMethod("changeStatus", Light.class, LightStatus.class);
        method.setAccessible(true);
        LightImpl lightImpl = new LightImpl(2, LightColour.RED);

        // act
        method.invoke(strategySequence, lightImpl, LightStatus.ON);

        // assert
        assertSame(LightStatus.ON, lightImpl.getLightStatus());
    }

    @Test
    public void shouldChangeLightStatusForAList() throws Exception {
        // Arrange
        Method method = AbstractStrategyImpl.class.getDeclaredMethod("changeStatus", List.class, LightStatus.class);
        method.setAccessible(true);
        List<Light> lights = LightsFactory.lightsBuilder(15);

        // act
        method.invoke(strategySequence , lights, LightStatus.ON);

        // assert
        for (Light light : lights) {
            assertSame(LightStatus.ON, light.getLightStatus());
        }

    }

    @Test
    public void shouldBlinkAndChangeStatusTwice() throws Exception {
        // Arrange
        Method method = AbstractStrategyImpl.class.getDeclaredMethod("flash", Light.class, int.class);
        LightImpl lightImpl = new LightImpl(2, LightColour.RED);

        // act
        method.invoke(strategySequence, lightImpl, 0);// no delay

        // assert
        assertEquals("Light 2 red on\n" + "Light 2 red off\n" , outContent.toString());
    }

    @Test
    public void shouldFlashAndChangeStatusForEachColour() throws Exception {
        // setup
        Method method = AbstractStrategyImpl.class.getDeclaredMethod("flash", List.class, int.class);
        List<Light> lights = LightsFactory.lightsBuilder(3);
        StringBuilder str = new StringBuilder();
        str.append("Light 1 red on\n").append("Light 2 green on\n").append("Light 3 white on\n").append("Light 1 red off\n")
                .append("Light 2 green off\n").append("Light 3 white off\n");

        // act
        method.invoke(strategySequence, lights, 0);// no delay required

        // assert
        assertEquals(str.toString(), outContent.toString());
    }

    @Test(timeout = 1080)
    public void shouldDelayByGivenMilliseconds() throws Exception {
        Method method = AbstractStrategyImpl.class.getDeclaredMethod("delay", long.class);
        long start = System.currentTimeMillis();
        method.invoke(strategySequence, 1000l);
        long end = System.currentTimeMillis();
        assertTrue("Should Sleep for one Sec.", (end - start) > 999);
    }
}
