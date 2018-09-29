package com.example.app.entity;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "locations")
public class AppGeoLocationEntity {
	private String id;
	private long timeStamp;
	private GeoJsonPoint location;
	
	public AppGeoLocationEntity(final long timeStamp, final GeoJsonPoint location) {
		this.timeStamp = timeStamp;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "AppGeoLocationEntity [id=" + id + ", timeStamp=" + timeStamp + ", location=" + location + "]";
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public GeoJsonPoint getLocation() {
		return location;
	}

	public void setLocation(GeoJsonPoint location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + (int) (timeStamp ^ (timeStamp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppGeoLocationEntity other = (AppGeoLocationEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (timeStamp != other.timeStamp)
			return false;
		return true;
	}
    
	
}
