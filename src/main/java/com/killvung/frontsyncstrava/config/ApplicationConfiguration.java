package com.killvung.frontsyncstrava.config;

import io.swagger.client.ApiClient;
import io.swagger.client.api.ActivitiesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

	private static CustomPropertiesConfig customPropertiesConfig;

	@Autowired
	public ApplicationConfiguration(CustomPropertiesConfig customPropertiesConfig){
		ApplicationConfiguration.customPropertiesConfig = customPropertiesConfig;
	}
	@Bean
	public ActivitiesApi activitiesApi(){
		ApiClient apiClient = new ApiClient();
		apiClient.setAccessToken(customPropertiesConfig.getConfigValue("access_token"));
		return new ActivitiesApi(apiClient);
	}
}
