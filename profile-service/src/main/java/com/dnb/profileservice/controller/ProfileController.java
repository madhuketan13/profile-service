package com.dnb.profileservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.exceptions.IdNotFoundException;
import com.dnb.profileservice.payload.request.ProfileRequest;
import com.dnb.profileservice.service.ProfileService;
import com.dnb.profileservice.utils.ProfileRequestToEntityMapper;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

	@Autowired
	ProfileService profileService;
	
	@Autowired
	ProfileRequestToEntityMapper mapper;

	@PostMapping("/create")
	public ResponseEntity<?> createProfile(@RequestBody ProfileRequest profile) throws IdNotFoundException {
		Profile profileRequest = mapper.getProfileEntity(profile);
		Profile profileData = profileService.createProfile(profileRequest);
		return new ResponseEntity(profileData, HttpStatus.CREATED);

	}

	@GetMapping("/{profileId}")
	public ResponseEntity<Profile> getProfile(@PathVariable("profileId") String profileId) throws IdNotFoundException {

		Optional<Profile> optional = profileService.getProfile(profileId);
		if (optional.isPresent()) {

			return ResponseEntity.ok(optional.get());
		} else {

			throw new IdNotFoundException("ID not found");
		}

	}
	
	@DeleteMapping("/{profileId}")
	public ResponseEntity<?> deleteProfile(@PathVariable("profileId") String profileId) throws IdNotFoundException{
		if(profileService.existsById(profileId)) {
			try
			{
				profileService.deleteProfile(profileId);
				return ResponseEntity.ok("acc deleted");
			} catch (IdNotFoundException e) {
				// TODO Auto-generated catch block
				throw new IdNotFoundException("Id not found");
			}
	}else {
		throw new IdNotFoundException("Id not found");
	}
	}
	
	@GetMapping("/getProfile/{userId}")
	public ResponseEntity<?> getProfileByUserId(@PathVariable("userId") int userId) throws IdNotFoundException{
		Optional<Profile> optional = profileService.getProfileByUserId(userId);
		if (optional.isPresent()) {

			return ResponseEntity.ok(optional.get());
		} else {

			throw new IdNotFoundException("userID not found");
		}
		
	}

}
