package com.dnb.profileservice.service;

import java.util.Optional;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.exceptions.IdNotFoundException;

public interface ProfileService {
	
	public Profile createProfile(Profile profile) throws IdNotFoundException;
	
	public Optional<Profile> getProfile(String userName);
	
	public Iterable<Profile> getAllProfiles();
	
	public boolean deleteProfile(String profileId) throws IdNotFoundException;
	
	public boolean existsById(String profileId);
	
	public Optional<Profile> getProfileByUserId(int userId);
}
