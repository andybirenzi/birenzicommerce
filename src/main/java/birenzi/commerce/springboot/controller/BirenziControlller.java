package birenzi.commerce.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BirenziControlller {
	@GetMapping(value = { "/", "/index" })
	public String index() {
		System.out.println("index");
		return "/pages/index";
	}

}
