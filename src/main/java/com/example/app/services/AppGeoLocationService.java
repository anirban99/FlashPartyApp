package com.example.app.services;

import java.util.List;

import com.example.app.entity.AppGeoLocationEntity;
import com.example.app.model.AppGeoLocation;


public interface AppGeoLocationService {


	public List<AppGeoLocationEntity> addLocations(long ts, List<AppGeoLocation> entries);
	
}
