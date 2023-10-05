package com.dnb.profileservice.payload.request;

import java.util.List;

import com.dnb.profileservice.dto.SocialNetwork;

import lombok.Data;

@Data
public class ProfileRequest {
	
	private String professionalStatus;
	private String company;
	private String website;
	private String location;
	private String skills;
	private String githubUsername;
	private SocialNetwork socialNetwork;
	private int userId;

}
