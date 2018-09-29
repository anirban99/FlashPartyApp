package com.example.app.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

public class AppUserEntity {
	
	@Id
    public String id;

    public String firstName;
    public String lastName;
    public List<String> interests;
    
	public AppUserEntity(String firstName, String lastName, List<String> interests) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.interests = interests;
	}

	@Override
	public String toString() {
		return "AppUserEntity [firstName=" + firstName + ", lastName=" + lastName + ", interests=" + interests + "]";
	}
	
	
    
    

}
