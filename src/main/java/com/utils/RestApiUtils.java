package com.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.model.GitHubUser;

@Component
public class RestApiUtils {

	public GitHubUser getGitHubUser(String userId) {
		RestTemplate restTemplate = new RestTemplate();
		GitHubUser user = restTemplate.getForObject("https://api.github.com/users/" + userId, GitHubUser.class);
		return user;
	}
}