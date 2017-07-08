package birenzi.commerce.springboot.controller;

import org.springframework.stereotype.Controller;

@Controller
public class BirenziControlller2 {
	
//	@Autowired
//	private UserService userService;
//
//	@RequestMapping(value = { "/", "/pages/login" }, method = RequestMethod.GET)
//	public ModelAndView login() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("pages/login");
//		return modelAndView;
//	}
//
//	@RequestMapping(value = "/registration", method = RequestMethod.GET)
//	public ModelAndView registration() {
//		ModelAndView modelAndView = new ModelAndView();
//		User user = new User();
//		modelAndView.addObject("user", user);
//		modelAndView.setViewName("pages/registration");
//		return modelAndView;
//	}
//
//	@RequestMapping(value = "/registration", method = RequestMethod.POST)
//	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
//		
//		ModelAndView modelAndView = new ModelAndView();
//		User userExists = userService.findUserByEmail(user.getEmail());
//		if (userExists != null) {
//			bindingResult.rejectValue("email", "error.user",
//					"There is already a user registered with the email provided");
//		}
//		if (bindingResult.hasErrors()) {
//			modelAndView.setViewName("pages/registration");
//			System.out.println("registration post");
//		} else {
//			userService.saveUser(user);
//			modelAndView.addObject("successMessage", "User has been registered successfully");
//			modelAndView.addObject("user", new User());
//			modelAndView.setViewName("pages/registration");
//
//		}
//		return modelAndView;
//	}
//
//	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
//	public ModelAndView home() {
//		ModelAndView modelAndView = new ModelAndView();
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		User user = userService.findUserByEmail(auth.getName());
//		modelAndView.addObject("userName",
//				"Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
//		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
//		modelAndView.setViewName("admin/home");
//		return modelAndView;
//	}

}
