package com.oneempower.auth.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oneempower.auth.model.User;
import com.oneempower.auth.security.SecurityService;
import com.oneempower.auth.service.UserService;
import com.oneempower.auth.validator.UserValidator;

@Controller
//@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        model.addAttribute("username", securityService.findLoggedInUsername());
        return "welcome";
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam(name = "keyword") Optional<String> keyword,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model
			,Pageable pageable) throws IOException {

			 pageable = PageRequest.of(page, size);
			Page<User> listUsers;
			// = userService.getAllUser(page,size);
			// tìm kiếm
			if (keyword.isPresent()) {
				listUsers =  userService.searchSinhVien(keyword, pageable);

				// listUsers = userService.findAllByFirstNameContaining(firstName.get(),
				// pageable);
			} else {
				listUsers = userService.findAll(pageable);
			}
			Map<String, Object> modelMap = new HashMap<>();
			modelMap.put("users", listUsers);
			return new ModelAndView("user", modelMap);
		}
	
    
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public String home(Model model){
//        List<User> users = userService.findAll();
//        System.out.println(users);
//        model.addAttribute("users",users);
//        return "user"; // return file 
//    }
    
    //them sv
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String  viewAddUser()
    {
        return "addUser";
    }
    
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public String insertUser(@ModelAttribute("insertUser") User user){
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
        userService.insert(user);
        return "redirect:/user";
    }
    
    //update sv
//    @PostMapping("/editUser/updateUser")
    @RequestMapping(value = "/editUser/updateUser", method = RequestMethod.POST)

    public String updateUser( @ModelAttribute("user") User user){
        userService.update( user);
        return "redirect:/user";
    }
//    @GetMapping("/editUser/{id}")
    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
    public String  viewUpdateUser(@PathVariable("id") Long id,User user, Model model)
    {
    	
        model.addAttribute("user", userService.findById(id));
        return "updateUser";

    }
    
    //xoa sv
//    @GetMapping("/deleteUser/{id}")
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/user";
    }
    
}
    
