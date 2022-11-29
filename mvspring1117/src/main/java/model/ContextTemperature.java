package model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextTemperature {
	@Bean (name="temperatureBean") 
	   public Centigrade createCentigradeBean(){
	      return new Centigrade();
	   }	
}
