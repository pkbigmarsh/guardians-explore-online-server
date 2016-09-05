package com.guardians.explore.online.endpoint;

import com.guardians.explore.online.controller.MatchController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/match")
public class MatchEndpoint {

	private MatchController matchController;

	@RequestMapping(value = "/create/{username}", method = RequestMethod.GET)
	public String create(@PathVariable String username) {
		return matchController.createNewMatch(username).getGameId().toString();
	}

	@Autowired
	public void setMatchController(MatchController matchController) {
		this.matchController = matchController;
	}
}