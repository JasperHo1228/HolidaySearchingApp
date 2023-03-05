package com.example.demo;

import com.example.demo.Entity.Vevent;
import com.example.demo.Service.HolidayService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class HolidayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolidayApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(HolidayService holidayservice) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			try {
				//create a list for json file data
				TypeReference<List<Vevent>> typeReference = new TypeReference<>(){};
				//get the json file path
				InputStream inputStream = TypeReference.class.getResourceAsStream("/json/holiday.json");
				//read json file out
				List<Vevent> holidays = mapper.readValue(inputStream,typeReference);
				//save in database
				holidayservice.save(holidays);

				//print out the json file data
				System.out.println(holidays);

				System.out.println("Saved!");

			}
			catch (IOException e) {
				System.out.println("Unable to save: " + e.getMessage());
			}
		};

	}

}
