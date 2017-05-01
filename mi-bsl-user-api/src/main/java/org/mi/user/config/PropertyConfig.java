package org.mi.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:process-apis-url.properties")
public class PropertyConfig {
	
	@Value("${user-process-api-url}")
	public String userProcessAPIURL;

	public String getUserProcessAPIURL() {
		return userProcessAPIURL;
	}

	public void setUserProcessAPIURL(String userProcessAPIURL) {
		this.userProcessAPIURL = userProcessAPIURL;
	}
	
	
}
