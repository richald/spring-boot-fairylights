package com.unisys.fairylights.springbootfairylights;

import com.unisys.fairylights.springbootfairylights.light.LightsFactory;
import com.unisys.fairylights.springbootfairylights.strategy.Strategy;
import com.unisys.fairylights.springbootfairylights.strategy.StrategyFactory;
import com.unisys.fairylights.springbootfairylights.util.Alerts;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFairylightsApplication implements CommandLineRunner {


	private static final String EXCEPTION_NO_ARGS = "Exception.NoArgs";

	private static Logger LOG = LoggerFactory.getLogger(SpringBootFairylightsApplication.class);

	String algorithmName = null;
	int numberOfLights = LightsFactory.NUMBER_OF_LIGHTS;

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(SpringBootFairylightsApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("EXECUTING : command line runner");

		if( args.length == 0){
			LOG.info(Alerts.getString(EXCEPTION_NO_ARGS));
			return;
		}

		if( args.length == 2 && isInteger(args[1])){
			numberOfLights = Integer.parseInt(args[1]);
		}

		Strategy strategy = StrategyFactory.getStrategy(args[0]);
		strategy.activateLigths(LightsFactory.lightsBuilder(numberOfLights));

	}

	public static boolean isInteger(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException numberFormatExcept) {
			LOG.error("numberFormatExcept: ",numberFormatExcept);
		}
		return false;
	}
}
