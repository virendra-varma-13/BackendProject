package com.virendra.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.virendra.firstproject.entity.Users;
import com.virendra.firstproject.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;




@Controller
public class UserController {

    @Autowired
    private UserService service;
    
    @GetMapping("/")
    public String home() {
        return "dashboard";
    }

    @GetMapping("/add_user")
    public String addNewUser() {
        return "NewUser";
    }
    
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute Users entity) {
        service.saveUser(entity);
        return "redirect:/all_users";
    }
    

    @GetMapping("/all_users")
    public ModelAndView getAllUsers() {
        List<Users> users = service.getAllUser();
        ModelAndView m = new ModelAndView();

        m.setViewName("AllUsers");
        m.addObject("users", users);
        return m;
    }

    
	@RequestMapping("/editUser/{id}")
	public String editUser(@PathVariable("id") int id, Model model) {
		Users u=service.getUser(id);
		model.addAttribute("user", u);
		return "UserEdit";
	}
    
	@RequestMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		service.deleteUserById(id);
		return "redirect:/all_users";
	}
    
    
}
