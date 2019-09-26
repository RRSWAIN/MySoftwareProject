package com.usa.fedral.gov.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
//lombok for setter ,getter,tostring,hashcode,equals
@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "ssa")
public class SsaAppProperties {

	
	  
	//map loads the key and value from the yaml file
	Map<String, String> ssaprops = new HashMap<>();

	/*By calling this method, other class can get key,value from yaml file
	 * 
	 * public Map<String, String> getSsaProps() {
		return ssaprops;}
	*/

}
