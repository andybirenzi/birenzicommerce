package birenzi.commerce.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BirenziControlller {
	@GetMapping(value = { "/", "/index" })
	public String index() {
		return "/pages/index";
	}
	@GetMapping(value = { "login"})
	public String login() {
		return "/pages/login";
	}

}
