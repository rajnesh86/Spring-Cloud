package io.mylearning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.mylearning.model.User;

@EnableDiscoveryClient
@RestController

public class UserController {

	@Value("${service.instance.name}")
	private String instance;

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public @ResponseBody User createRide() {
		User user = new User();
		user.setId(1);
		System.out.println(instance);
		user.setUserName(instance);

		return user;

	}

	@RequestMapping("/")
	public String message() {
		return "Hello from " + instance;

	}

}
