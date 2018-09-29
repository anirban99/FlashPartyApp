package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.AppGeoLocationEntity;
import com.example.app.model.AppGeoLocation;
import com.example.app.repository.AppGeoLocationRepository;
import com.example.app.services.AppGeoLocationServiceImpl;


@RestController
public class AppGeoLocationController {

	@Autowired
	private AppGeoLocationRepository repository;
	
	@Autowired
	private AppGeoLocationServiceImpl service;	
		
	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)	
	public List<AppGeoLocationEntity> addLocations(
		@RequestParam("ts") long ts,
		@RequestBody List<AppGeoLocation> entries){
		return service.addLocations(ts, entries);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public final List<AppGeoLocationEntity> getLocations(
		@RequestParam(value = "ts", required = false) long ts,
		@RequestParam("lat") String latitude,
	    @RequestParam("long") String longitude,
	    @RequestParam("d") double distance) {
		
		if (distance < 50){
		List<AppGeoLocationEntity> list = this.repository.findBytimeStampAndLocationNear(ts,
			      new Point(Double.valueOf(longitude), Double.valueOf(latitude)),
			      new Distance(distance, Metrics.KILOMETERS));
		
		return list;
		}
//	    return this.repository.findBytimeStampAndLocationNear(ts,
//	      new Point(Double.valueOf(longitude), Double.valueOf(latitude)),
//	      new Distance(distance, Metrics.KILOMETERS));
		
		return null;
	 }
	
//	@RequestMapping(path = "/getlocation", method = RequestMethod.GET, produces = "application/json")
//	public List<AppGeoLocationEntity> getLocations(
//		@RequestParam("lat") String latitude,
//		@RequestParam("long") String longitude,
//		@RequestParam("d") double distance,
//		@RequestParam(value = "ts", required = false) long ts){
//		return service.findBytimeStampAndLocationNear(ts,
//			      new Point(Double.valueOf(longitude), Double.valueOf(latitude)),
//			      distance);
//	}
	
//	 @RequestMapping(path = "/addlocation", method = RequestMethod.POST)
//	 @ResponseStatus(HttpStatus.CREATED)
//	 public final void addLocations(
//	    @RequestParam("ts") long ts,
//	    @RequestBody List<AppGeoLocation> entries) {
//
//	    List<AppGeoLocationEntity> entities = new ArrayList<>();
//	    for (AppGeoLocation location : entries) {
//	      final GeoJsonPoint locationPoint = new GeoJsonPoint(
//	    		Double.valueOf(23.5),
//	  	        Double.valueOf(42.5));
//	    		  
////	        Double.valueOf(location.getLongitude()),
////	        Double.valueOf(location.getLatitude()));
//
//	      entities.add(new AppGeoLocationEntity(125056L, locationPoint));
//	      System.out.println(entities);
//	    }
//
//	    this.repository.save(entities);
//	  }
	 
	 
}
