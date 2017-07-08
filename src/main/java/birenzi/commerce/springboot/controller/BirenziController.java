package birenzi.commerce.springboot.controller;

import javax.validation.Valid;

import org.hibernate.annotations.GeneratorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import birenzi.commerce.springboot.pojo.Brand;
import birenzi.commerce.springboot.pojo.Category;
import birenzi.commerce.springboot.pojo.Product;
import birenzi.commerce.springboot.repository.BrandRepository;
import birenzi.commerce.springboot.service.CategoryService;
import birenzi.commerce.springboot.service.ProductService;

@Controller
public class Controller {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BrandRepository brandRepo;
	// private static final Logger birenzilog=
	// LoggerFactory.logger(BirenziControllerUpdated);

	@GetMapping(value = { "/products", "/" })
	public String productIndex(Model model) {
		model.addAttribute("listproduct", productService.findAllProduct());
		return "templates/products";
	}

	@GetMapping(value = "/addproduct")
	public String addproduct(Model model) {
		model.addAttribute("newproduct", new Product());
		model.addAttribute("brands", brandRepo.findAll());
		model.addAttribute("categories", categoryService.findAllCategories());
		return "templates/addproduct";
	}

	@PostMapping(value = "/addproduct")
	public String saveProduct(@Valid @ModelAttribute("newproduct") Product newproduct, BindingResult result) {
		if (result.hasErrors()) {
            logger.error("new product filled are not completed");;
			return "templates/addproduct";

		} else if (newproduct != null && newproduct.getId() != 0) {
			Product product = productService.findProductById(newproduct.getId());
			product.update(newproduct.getSku(), newproduct.getLabel(), newproduct.getDescription(),
					newproduct.getProductBrand(), newproduct.getProductCategory());
			productService.update(product);
			logger.info("product updated");
		} else{
			productService.saveProduct(newproduct);
			logger.info("new product saved");
		}
          
		return "redirect:/products";
	}

	@GetMapping(value = "/deleteproduct/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		productService.deleteProduct(id);

		return "redirect:/products";

	}

	@GetMapping(value = "/editproduct/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		model.addAttribute("newproduct", productService.findProductById(id));
		model.addAttribute("brands", brandRepo.findAll());
		model.addAttribute("categories", categoryService.findAllCategories());
		return "templates/addproduct";

	}

	@GetMapping(value = "/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("newcategory", new Category());
		model.addAttribute("categories", categoryService.findAllCategories());
		return "templates/addcategory";

	}

	@PostMapping(value = "/addcategory")
	public String addCategory(@Valid @ModelAttribute("newcategory") Category cat, BindingResult bind) {

		if (bind.hasErrors()) {
			return "templates/addcategory";
		} else if (cat != null && cat.getId() != 0 && cat.getParent() != null) {
			Category categoryUpdated = categoryService.findOne(cat.getId());
			categoryUpdated.update(cat.getLabel(), cat.getDescription(), cat.getParent());
			categoryService.updateCategory(cat);
		} else
			categoryService.saveCategory(cat);
		return "redirect:/categories";
	}

	@GetMapping(value = "/categories")
	public String categories(Model model) {
		model.addAttribute("categories", categoryService.findAllCategories());
		return "templates/categories";

	}

	@GetMapping(value = "/deletecategory/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		categoryService.delete(id);
		System.out.println("delete id:" + id);
		return "redirect:/categories";

	}

	@GetMapping(value = "/editcategory/{id}")
	public String editCategory(@PathVariable("id") int id, Model model) {
		Category category = categoryService.findOne(id);
		if (category.getParent() == null) {
			category.setParent(new Category());
			category.getParent().setId(0);
		}
		model.addAttribute("newcategory", category);
		model.addAttribute("categories", categoryService.findAllCategories());
		return "templates/addcategory";

	}

	// brand
	@GetMapping(value = "/addbrand")
	public String addBrand(Model model) {
		model.addAttribute("newbrand", new Brand());
		return "templates/addbrand";

	}

	@PostMapping(value = "/addbrand")
	public String addBrand(@Valid @ModelAttribute("newbrand") Brand brand, BindingResult bind) {
		System.out.println("brand " + brand.getId() + " " + brand.getLabel() + " " + brand.getDescription());
		if (bind.hasErrors()) {
			return "templates/addcategory";
		} else if (brand != null && brand.getId() != 0) {
			Brand updatedBrand = brandRepo.findOne(brand.getId());
			updatedBrand.update(brand.getLabel(), brand.getDescription());
			brandRepo.flush();
			System.out.println("Updated");
		} else {

			brandRepo.save(brand);
			System.out.println("saved " + brand.getId() + " works");
		}
		return "redirect:/brands";
	}

	@GetMapping(value = "/brands")
	public String brand(Model model) {
		model.addAttribute("brands", brandRepo.findAll());
		return "templates/brands";

	}

	@GetMapping(value = "/deletebrand/{id}")
	public String deleteBrand(@PathVariable("id") int id) {
		brandRepo.delete(id);

		return "redirect:/brands";

	}

	@GetMapping(value = "/editbrand/{id}")
	public String editBrand(@PathVariable("id") int id, Model model) {
		model.addAttribute("newbrand", brandRepo.findOne(id));
		return "templates/addbrand";

	}

}
