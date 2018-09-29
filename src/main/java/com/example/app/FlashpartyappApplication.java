package com.example.app;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.boot.CommandLineRunner;

import com.example.app.entity.AppGeoLocationEntity;
import com.example.app.entity.AppUserEntity;
import com.example.app.repository.AppGeoLocationRepository;
import com.example.app.repository.AppUserRepository;

@SpringBootApplication
@ComponentScan({"com.example.app.services"})
public class FlashpartyappApplication implements CommandLineRunner {
	
	
	@Autowired
	private AppGeoLocationRepository locationRepository;
	
	@Autowired
	private AppUserRepository userRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(FlashpartyappApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();

		// save a couple of users
		userRepository.save(new AppUserEntity("Thomas", "Muller", Arrays.asList("Hiking", "Gaming")));
		userRepository.save(new AppUserEntity("Bastian", "Muller", Arrays.asList("Football", "Travelling")));

		// fetch all users
		System.out.println("Users found with findAll():");
		System.out.println("-------------------------------");
		for (AppUserEntity user : userRepository.findAll()) {
			System.out.println(user);
		}
		System.out.println();

		System.out.println("Users found with findByLastName('Muller'):");
		System.out.println("--------------------------------");
		for (AppUserEntity user : userRepository.findByLastName("Muller")) {
			System.out.println(user);
		}
		System.out.println();
		
		locationRepository.deleteAll();
		
		locationRepository.save(new AppGeoLocationEntity(12345L,
				new GeoJsonPoint(Double.valueOf(8.41),Double.valueOf(50.7))));
		locationRepository.save(new AppGeoLocationEntity(6578904L,
				new GeoJsonPoint(Double.valueOf(6.81),Double.valueOf(51.22))));
		
		System.out.println("Location found with findAll():");
		System.out.println("-------------------------------");
		for (AppGeoLocationEntity location : locationRepository.findAll()) {
			System.out.println(location);
		}
		System.out.println();
		
		System.out.println("Location found with findBytimeStamp():");
		System.out.println("--------------------------------");
		for (AppGeoLocationEntity location : locationRepository.findBytimeStamp(6578904L)) {
			System.out.println(location);
		}
		System.out.println();
		
//		System.out.println("Location found with findBytimeStampAndLocationNear():");
//		System.out.println("--------------------------------");
//		for (AppGeoLocationEntity location : locationRepository.findBytimeStampAndLocationNear(
//			12345L, new GeoJsonPoint(Double.valueOf(8.41),Double.valueOf(50.7)), new Distance(200, Metrics.KILOMETERS))) {
//			System.out.println(location);
//		}
//		System.out.println();

	}
}
