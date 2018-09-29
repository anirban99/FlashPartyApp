package com.example.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.app.entity.AppUserEntity;

public interface AppUserRepository extends MongoRepository<AppUserEntity, String> {
	
	public AppUserEntity findByFirstName(String firstName);
    public List<AppUserEntity> findByLastName(String lastName);
}
