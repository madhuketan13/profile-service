package com.dnb.profileservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.dto.User;
import com.dnb.profileservice.exceptions.IdNotFoundException;
import com.dnb.profileservice.payload.request.ProfileRequest;
import com.dnb.profileservice.repo.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${api.user1}")
	private String URL;

	@Override
	public Profile createProfile(Profile profile) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			System.out.println(profile.getSkills());
			ResponseEntity<User> responseEntity = restTemplate.getForEntity(URL+"/"+profile.getUserId() , User.class);
			return profileRepository.save(profile);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			throw new IdNotFoundException(e.getMessage());
		}
		
	}

	@Override
	public Optional<Profile> getProfile(String userName) {
		// TODO Auto-generated method stub
		return profileRepository.findById(userName);
	}

	@Override
	public Iterable<Profile> getAllProfiles() {
		// TODO Auto-generated method stub
		return profileRepository.findAll();
	}

	@Override
	public boolean deleteProfile(String profileId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean existsById(String profileId) {
		return profileRepository.existsById(profileId);
	}

	@Override
	public Optional<Profile> getProfileByUserId(int userId) {
		// TODO Auto-generated method stub
		return profileRepository.findByUserId(userId);
	}

}
