package com.usa.fedral.gov.model;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
public class StatesModel {

	private Integer stateId;
	private String stateName;
}
