package com.guardians.explore.online.configuration;

import com.guardians.explore.online.controller.MatchController;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class CoreConfiguration {

	@Bean
	public MatchController MatchController () {
		return new MatchController();
	}
}