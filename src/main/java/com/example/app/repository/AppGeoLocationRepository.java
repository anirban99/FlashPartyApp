package com.example.app.repository;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.app.entity.AppGeoLocationEntity;


public interface AppGeoLocationRepository extends MongoRepository<AppGeoLocationEntity, String> {

	  List<AppGeoLocationEntity> findBytimeStampAndLocationNear(long ts, Point p, Distance d);
	  
	  List<AppGeoLocationEntity> findBytimeStamp(long ts);
	}
