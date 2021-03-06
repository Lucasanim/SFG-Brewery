package group.springframework.brewery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;

@SpringBootApplication//(exclude = ArtemisAutoConfiguration.class)
public class BreweryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreweryApplication.class, args);
	}

}
