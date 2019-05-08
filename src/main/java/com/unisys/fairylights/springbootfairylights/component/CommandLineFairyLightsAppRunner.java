package com.unisys.fairylights.springbootfairylights.component;

import com.unisys.fairylights.springbootfairylights.light.LightsFactory;
import com.unisys.fairylights.springbootfairylights.strategy.Strategy;
import com.unisys.fairylights.springbootfairylights.strategy.StrategyFactory;
import com.unisys.fairylights.springbootfairylights.util.Alerts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineFairyLightsAppRunner implements CommandLineRunner {

    private static final String EXCEPTION_NO_ARGS = "Exception.NoArgs";

    private static Logger LOG = LoggerFactory.getLogger(CommandLineFairyLightsAppRunner.class);

    private int numberOfLights = LightsFactory.NUMBER_OF_LIGHTS;

    @Override
    public void run(String... args) throws Exception {

        if( args.length == 0){
            LOG.info(Alerts.getString(EXCEPTION_NO_ARGS));
            return;
        }

        if( args.length == 2 && isInteger(args[1])){
            numberOfLights = Integer.parseInt(args[1]);
        }

        action(args[0],numberOfLights);

    }

    private static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException numberFormatExcept) {
            LOG.error("numberFormatExcept: ",numberFormatExcept);
        }
        return false;
    }

    public void action(String strategyName, int numberOfLights) {
        action(StrategyFactory.getStrategy(strategyName), numberOfLights);
    }

    public void action(Strategy strategy, int numberOfLights) {
        strategy.activateLigths(LightsFactory.lightsBuilder(numberOfLights));
    }
}
