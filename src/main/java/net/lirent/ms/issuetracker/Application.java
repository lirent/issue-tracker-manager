package net.lirent.ms.issuetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Spring Boot application class for component scan and extra configuration
 *
 * @author l.pone
 */
@SpringBootApplication
public class Application {
	/**
	 * main method to bootstrap and launch the Spring application
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
