package com.dnb.profileservice.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.dto.SocialNetwork;
import com.dnb.profileservice.payload.request.ProfileRequest;

@Component
public class ProfileRequestToEntityMapper {
	@Autowired 
	Converter converter;
	public Profile getProfileEntity(ProfileRequest profileRequest) {
		
		Profile profile = new Profile();
		profile.setProfessionalStatus(profileRequest.getProfessionalStatus());
		profile.setCompany(profileRequest.getCompany());
		profile.setWebsite(profileRequest.getWebsite());
		profile.setLocation(profileRequest.getLocation());
		profile.setSkills(profileRequest.getSkills());
		profile.setGithubUsername(profileRequest.getGithubUsername());
		profile.setUserId(profileRequest.getUserId());
		
		SocialNetwork socialNetwork = new SocialNetwork();
		socialNetwork.setTwitterUrl(profileRequest.getSocialNetwork().getTwitterUrl());
		socialNetwork.setFacebookUrl(profileRequest.getSocialNetwork().getFacebookUrl());
		socialNetwork.setYoutubeUrl(profileRequest.getSocialNetwork().getYoutubeUrl());
		socialNetwork.setLinkedinUrl(profileRequest.getSocialNetwork().getLinkedinUrl());
		socialNetwork.setInstagramUrl(profileRequest.getSocialNetwork().getInstagramUrl());
		
		profile.setSocialNetwork(socialNetwork);
		
		return profile;
	}

}
