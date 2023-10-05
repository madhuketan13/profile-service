package com.dnb.profileservice.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
@Component
public class Converter {
	
	public String listToString(List<String> input) {
		return input.stream().collect(Collectors.joining(","));		
	}

	public List<String> stringToList(String list){
		return Arrays.asList(list.split(","));
	}

}
