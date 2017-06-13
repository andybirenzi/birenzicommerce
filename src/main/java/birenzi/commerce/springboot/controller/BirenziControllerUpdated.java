package birenzi.commerce.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import birenzi.commerce.springboot.pojo.Product;
import birenzi.commerce.springboot.service.ProductService;

@Controller
public class BirenziControllerUpdated {
	@Autowired
	private ProductService productService;


	@GetMapping(value = { "/products", "/" })
	public String productIndex(Model model) {
		System.out.println("see all products");
		model.addAttribute("listproduct",productService.findAllProduct());
		return "templates/products";
	}

	@GetMapping(value = "/addproduct")
	public String addproduct(Model model) {
		model.addAttribute("newproduct", new Product());
		return "templates/addproduct";
	}

	@PostMapping(value = "/addproduct")
	public String saveProduct(@Valid @ModelAttribute("newproduct") Product newproduct,BindingResult result) {
		if (result.hasErrors()) {
			
			return "templates/addproduct";

		} else
          
		productService.saveProduct(newproduct);

		return "redirect:/products";
	}

}
