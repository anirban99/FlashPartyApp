package com.example.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import com.example.app.entity.AppGeoLocationEntity;
import com.example.app.model.AppGeoLocation;
import com.example.app.repository.AppGeoLocationRepository;

public class AppGeoLocationServiceImpl {
	
	@Autowired
	private AppGeoLocationRepository repository;

	public List<AppGeoLocationEntity> addLocations(long ts, List<AppGeoLocation> entries) {
		// TODO Auto-generated method stub
		List<AppGeoLocationEntity> entities = new ArrayList<>();
	    for (AppGeoLocation location : entries) {
	      final GeoJsonPoint locationPoint = new GeoJsonPoint(	    		  
	        Double.valueOf(location.getLongitude()),
	        Double.valueOf(location.getLatitude()));

	      entities.add(new AppGeoLocationEntity(ts, locationPoint));
	    }

	    repository.save(entities);	
	    return entities;
	}
}
