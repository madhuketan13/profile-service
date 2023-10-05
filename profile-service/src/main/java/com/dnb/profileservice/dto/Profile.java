package com.dnb.profileservice.dto;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.profileservice.utils.CustomProfileIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Profile {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_seq")
	@GenericGenerator(name = "profile_seq", strategy = "com.dnb.profileservice.utils.CustomProfileIdGenerator",
	parameters = {@Parameter(name = CustomProfileIdGenerator.INCREMENT_PARAM, value = "50"),
	@Parameter(name = CustomProfileIdGenerator.VALUE_PREFIX_PARAMETER, value = "profile_"),
	@Parameter(name = CustomProfileIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	@Column private String profileId;
	@Column private String professionalStatus;
	@Column private String company;
	@Column private String website;
	@Column private String location;
	@Column private String skills;
	@Column private String githubUsername;
	@Embedded
	private SocialNetwork socialNetwork;
	private int userId;

}
