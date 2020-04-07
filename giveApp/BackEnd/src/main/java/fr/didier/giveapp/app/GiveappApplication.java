package fr.didier.giveapp.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GiveappApplication {

	private final Logger logger = LoggerFactory.getLogger(GiveappApplication.class);

	public static void main(String[] args)
	{
		SpringApplication.run(GiveappApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(final DataInitializer initializer) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				logger.info(
						"\n ******** Initializing Data ********");
				initializer.initData();

				logger.info(
						"\n ******** Data initialized ********");
			}
		};
	}
}
