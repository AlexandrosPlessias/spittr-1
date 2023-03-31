package com.spittr.spittr_app;

import com.spittr.spittr_app.models.Spitter;
import com.spittr.spittr_app.models.Spittle;
import com.spittr.spittr_app.services.SpitterService;
import com.spittr.spittr_app.services.SpittleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpittrAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpittrAppApplication.class, args);

		// ----------- Spitter -----------
		SpitterService spitterService = new SpitterService();
		spitterService.createSpitter("leondardodicaprio2", "4567", "leonardo", "dicaprio", "dicaprio@gmail.com");


		Spitter spitterDicaprio= spitterService.readSpitterByUsername("leondardodicaprio");
		System.out.println(spitterDicaprio.toString());

		spitterService.updateSpitterEmailByUsername("leonelMessi", "leo@gmail.com");
		System.out.println(spitterService.readSpitterByUsername("leonelMessi"));
		
		/* Delete */

		// ----------- Spittle -----------
		SpittleService spittleService = new SpittleService();
		spittleService.createSpittle("Good Morning!","10:30", 123456.789, 987654.321);

		Spittle hello = spittleService.readSpittleById(1024L);
		System.out.println(hello.toString());

		/* Update *
//		spittleService.updateSpittleMessage(1024L, "Good Night!");
//		System.out.println(spittleService.readSpittleById(1024L));

		/* Delete */

	}

}
