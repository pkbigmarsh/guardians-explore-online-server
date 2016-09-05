package com.guardians.explore.online.endpoint;

import com.guardians.explore.online.controller.MatchController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@EnableAutoConfiguration
@RequestMapping("/match")
public class MatchEndpoint {

	private MatchController matchController;

	@RequestMapping(value = "/create/{username}",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
	public String create(@PathVariable String username) {
		return matchController.createNewMatch(username).getMatchId().toString();
	}

	@RequestMapping(value = "/join/{matchId}", method = RequestMethod.GET)
    public String join(@PathVariable UUID matchId, @RequestHeader("user") String username) {
        return matchController.joinMatch(matchId, username);
    }

	@Autowired
	public void setMatchController(MatchController matchController) {
		this.matchController = matchController;
	}
}