package com.assignment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsvJpaApplication {

	// logging operation are done through Logger
	private static final Logger LOGGER = LogManager.getLogger(CsvJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CsvJpaApplication.class, args);

		// printing the messages using logger
		LOGGER.error("Error level log message not actual error");
		LOGGER.info("Info level log message");
		LOGGER.debug("Debug level log message");
	}
}
