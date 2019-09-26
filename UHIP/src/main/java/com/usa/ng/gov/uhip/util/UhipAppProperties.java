package com.usa.ng.gov.uhip.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
@Data
@Configuration
@ConfigurationProperties(prefix="uhip")
@EnableConfigurationProperties
public class UhipAppProperties {

	private Map<String,String> uhipprops=new HashMap<String, String>();
}
