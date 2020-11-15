package com.killvung.frontsyncstrava.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
// Ignore the error defined by IntelliJ, this indeed work
@PropertySource("classpath:custom-${spring.profiles.active}.properties")
public class CustomPropertiesConfig {
	private final Environment env;

	public CustomPropertiesConfig(Environment env) {
		this.env = env;
	}

	public String getConfigValue(String configKey) {
		return env.getProperty(configKey);
	}
}
